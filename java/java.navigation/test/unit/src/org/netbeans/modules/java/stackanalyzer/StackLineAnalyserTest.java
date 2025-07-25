/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.java.stackanalyzer;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.DefaultListModel;
import org.junit.Test;
import org.netbeans.junit.NbTestCase;

/**
 *
 * @author Jan Lahoda
 */
public class StackLineAnalyserTest extends NbTestCase {

    public StackLineAnalyserTest(String name) {
        super(name);
    }

    @Test
    public void testMatches() throws Exception {
        assertTrue(StackLineAnalyser.matches("at java.lang.String.lastIndexOf(String.java:1627)"));
        assertTrue(StackLineAnalyser.matches(" at java.lang.String.lastIndexOf(String.java:1627)"));
        assertTrue(StackLineAnalyser.matches("asdf at java.lang.String.lastIndexOf(String.java:1627)"));
        assertTrue(StackLineAnalyser.matches("at java.lang.String.lastIndexOf(String.java:1627) asdf"));
        assertTrue(StackLineAnalyser.matches("at org.netbeans.modules.x.SessionNode.<init>(SessionNode.java:131)"));
        assertTrue(StackLineAnalyser.matches("at org.netbeans.modules.x.SessionNode.<clinit>(SessionNode.java:131)"));
        assertTrue(StackLineAnalyser.matches("at javaapplication8.Main$1.run(Main.java:32)"));
        assertTrue(StackLineAnalyser.matches("at javaapplication8.Main$Inner.go(Main.java:40)"));
        assertTrue(StackLineAnalyser.matches("             [exec]     at org.openide.filesystems.FileUtil.normalizeFileOnMac(FileUtil.java:1714)"));
        assertTrue(StackLineAnalyser.matches("at java.base/java.lang.String.lastIndexOf(String.java:1627)"));
        assertTrue(StackLineAnalyser.matches(" at java.base/java.lang.String.lastIndexOf(String.java:1627)"));
        // surefire + module info in src and test sources
        assertTrue(StackLineAnalyser.matches("	at Mavenproject1/dev.mbien.mavenproject1.Mavenproject1.foo(Mavenproject1.java:15)"));
        // surefire + module info in src but _no_ module info for test sources
        assertTrue(StackLineAnalyser.matches("	at Mavenproject1@0.1-SNAPSHOT/dev.mbien.mavenproject1.Mavenproject1.foo(Mavenproject1.java:11)"));
        // some loggers (e.g. MavenSimpleLogger until MNG-7970/#1342 which is maven's default logger) seem to add a space before the '('
        assertTrue(StackLineAnalyser.matches("    at java.util.zip.ZipFile$CleanableResource.<init> (ZipFile.java:742)"));
    }

    @Test
    public void testMatchesScalaLines() throws Exception {
        String line = "at org.enso.compiler.core.ir.MetadataStorage.$anonfun$getUnsafe$1(MetadataStorage.scala:80)";
        assertTrue(StackLineAnalyser.matches(line));
        StackLineAnalyser.Link l = StackLineAnalyser.analyse(line);
        assertEquals(3, l.getStartOffset());
        assertEquals(91, l.getEndOffset());
        assertEquals(".scala", l.getExtension());
    }

    @Test
    public void testMatchesUnknownFileLines() throws Exception {
        String line = "at org.Unknown(Unknown:80)";
        assertTrue(StackLineAnalyser.matches(line));
        StackLineAnalyser.Link l = StackLineAnalyser.analyse(line);
        assertEquals(3, l.getStartOffset());
        assertEquals(26, l.getEndOffset());
        assertEquals(null, l.getExtension());
    }

    @Test
    public void testMatchesWithNoPackage() throws Exception {
        String line = "\tat NewClass.main(NewClass.java:12)";
        assertTrue(StackLineAnalyser.matches(line));
        StackLineAnalyser.Link l = StackLineAnalyser.analyse(line);
        assertEquals(4, l.getStartOffset());
        assertEquals(35, l.getEndOffset());
        assertEquals(".java", l.getExtension());
    }

    @Test
    public void testModuleStackTraceMatches() throws Exception {
        assertTrue(StackLineAnalyser.matches("at library.Library.init(Utilities/Library.java:24)"));
        assertTrue(StackLineAnalyser.matches("at library.Library.init(org.netbeans.api.Utilities/Library.java:24)"));
    }

    @Test
    public void testAnalyse() throws Exception {
        StackLineAnalyser.Link l = StackLineAnalyser.analyse("at java.lang.String.lastIndexOf(String.java:1627)");
        assertEquals(3, l.getStartOffset());
        assertEquals(49, l.getEndOffset());
        l = StackLineAnalyser.analyse(" at java.lang.String.lastIndexOf(String.java:1627)");
        assertEquals(4, l.getStartOffset());
        assertEquals(50, l.getEndOffset());
        l = StackLineAnalyser.analyse("asdf at java.lang.String.lastIndexOf(String.java:1627)");
        assertEquals(8, l.getStartOffset());
        assertEquals(54, l.getEndOffset());
        l = StackLineAnalyser.analyse("at java.lang.String.lastIndexOf(String.java:1627) dfasdf");
        assertEquals(3, l.getStartOffset());
        assertEquals(49, l.getEndOffset());
        l = StackLineAnalyser.analyse("at java.base/java.lang.String.lastIndexOf(String.java:1627)");
        assertEquals(3, l.getStartOffset());
        assertEquals(59, l.getEndOffset());
        l = StackLineAnalyser.analyse(" at java.base/java.lang.String.lastIndexOf(String.java:1627)");
        assertEquals(4, l.getStartOffset());
        assertEquals(60, l.getEndOffset());
        l = StackLineAnalyser.analyse("    at java.util.zip.ZipFile$CleanableResource.<init> (ZipFile.java:742)");
        assertEquals(7, l.getStartOffset());
        assertEquals(72, l.getEndOffset());
    }

    @Test
    public void testFillListModelSimple() throws Exception {
        testFillListModelSkeleton(
                      "at java.lang.String.lastIndexOf(String.java:1627)",
        new String[] {"at java.lang.String.lastIndexOf(String.java:1627)"});
    }

    private void testFillListModelSkeleton(String input, String []output) throws Exception {
        StringReader sr = new StringReader(input);
        BufferedReader r = new BufferedReader (sr);
        DefaultListModel model = new DefaultListModel ();
        AnalyzeStackTopComponent.fillListModel(r, model);
        for (int i = 0; i < output.length; i++) {
            assertEquals(output[i], model.elementAt(i));
        }
    }

    @Test
    public void testFillListModelTrim() throws Exception {
        testFillListModelSkeleton(
                      "  at java.lang.String.lastIndexOf(String.java:1627)  ",
        new String[] {"at java.lang.String.lastIndexOf(String.java:1627)"});
    }
    @Test
    public void testFillListModelTwoLines1() throws Exception {
        testFillListModelSkeleton(
                      "at java.lang.Str\ning.lastIndexOf(String.java:1627)",
        new String[] {"at java.lang.String.lastIndexOf(String.java:1627)"});
    }
    @Test
    public void testFillListModelTwoLines2() throws Exception {
        testFillListModelSkeleton(
                      "asdf at java.lang.String.last\nIndexOf(String.java:1627)",
        new String[] {"asdf at java.lang.String.lastIndexOf(String.java:1627)"});
    }
    @Test
    public void testFillListModelNonMatchingLine() throws Exception {
        testFillListModelSkeleton(
                      "asdf a sdfasdf asdf a fafd \n" +
                      "at java.lang.String.lastIndexOf(String.java:1627)",
        new String[] {"asdf a sdfasdf asdf a fafd",
                      "at java.lang.String.lastIndexOf(String.java:1627)"});
    }
    @Test
    public void testFillListModelNonMatchingLine2() throws Exception {
        testFillListModelSkeleton(
                      "asdf a sdfasdf asdf a fafd \n" +
                      "at java.lang.String.lastIn\ndexOf(String.java:1627)",
        new String[] {"asdf a sdfasdf asdf a fafd",
                      "at java.lang.String.lastIndexOf(String.java:1627)"});
    }
    @Test
    public void testFillListModelNonMatchingLine3() throws Exception {
        testFillListModelSkeleton(
                      "             [exec]     at\n" +
                      "org.openide.filesystems.FileUtil.normalizeFileOnMac(FileUtil.java:1714)",
        new String[] {"[exec]     at org.openide.filesystems.FileUtil.normalizeFileOnMac(FileUtil.java:1714)"});
    }
    @Test
    public void testFillListModelInner() throws Exception {
        testFillListModelSkeleton(
                      "at javaapplication8.Main$Inn\ner.go(Main.java:40)",
        new String[] {"at javaapplication8.Main$Inner.go(Main.java:40)"});
    }
    @Test
    public void testFillListModelInner2() throws Exception {
        testFillListModelSkeleton(
                      "   at\njavaapplication8.Main$Inner.go(Main.java:40)",
        new String[] {"at javaapplication8.Main$Inner.go(Main.java:40)"});
    }
    @Test
    public void testFillListModelAnonymous() throws Exception {
        testFillListModelSkeleton(
                      " at javaapp\nlication8.Main$1.run(Main.java:32)",
        new String[] {"at javaapplication8.Main$1.run(Main.java:32)"});
    }
    @Test
    public void testFillListModelComplex() throws Exception {
        testFillListModelSkeleton(
                      "   java.lang.Thread.State: WAITING (parking)\n" +
                      "    at sun.misc.Unsafe.park(Native Method)\n" +
                      "    - parking to wait for  <0x000000010c0773e8> (a\n" +
                      "java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)\n" +
                      "    at java.util.concurrent.locks.LockSupport.park(LockSupport.java:158)\n" +
                      "    at\n" +
                      "java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:1925)\n" +
                      "    at\n" +
                      "java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:358)\n" +
                      "    at\n" +
                      "java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:947)\n" +
                      "    at\n" +
                      "java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:907)\n" +
                      "    at java.lang.Thread.run(Thread.java:637)\n",
        new String[] {
                      "java.lang.Thread.State: WAITING (parking)",
                      "at sun.misc.Unsafe.park(Native Method)",
                      "- parking to wait for  <0x000000010c0773e8> (a",
                      "java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)",
                      "at java.util.concurrent.locks.LockSupport.park(LockSupport.java:158)",
                      "at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:1925)",
                      "at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:358)",
                      "at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:947)",
                      "at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:907)",
                      "at java.lang.Thread.run(Thread.java:637)"
        });
    }

    @Test
    public void testMultiLanguageStackFromEnso() throws Exception {
        var stack = """
        Execution finished with an error: java.lang.IllegalStateException: No persistance for java.time.LocalDate
                at <java> org.enso.jvm.interop.OtherJvmMessage$ThrowException.value(OtherJvmMessage.java:54)
                at <java> org.enso.jvm.interop.OtherJvmObject.send(OtherJvmObject.java:63)
                at <java> org.enso.jvm.interop.OtherJvmObjectGen$ReflectionLibraryExports$Cached.send(OtherJvmObjectGen.java:65)
                at <java> org.graalvm.truffle/com.oracle.truffle.api.interop.InteropLibraryGen$Proxy.invokeMember(InteropLibraryGen.java:2899)
                at <java> org.graalvm.truffle/com.oracle.truffle.api.interop.InteropLibraryGen$CachedDispatch.invokeMember(InteropLibraryGen.java:8497)
                at <java> org.enso.interpreter.node.callable.resolver.HostMethodCallNode.resolveHostMethod(HostMethodCallNode.java:223)
                at <java> org.enso.interpreter.node.callable.resolver.HostMethodCallNodeGen.executeAndSpecialize(HostMethodCallNodeGen.java:152)
                at <java> org.enso.interpreter.node.callable.resolver.HostMethodCallNodeGen.execute(HostMethodCallNodeGen.java:114)
                at <java> org.enso.interpreter.node.callable.InvokeMethodNode.doPolyglot(InvokeMethodNode.java:562)
                at <java> org.enso.interpreter.node.callable.InvokeMethodNodeGen.executeAndSpecialize(InvokeMethodNodeGen.java:868)
                at <java> org.enso.interpreter.node.callable.InvokeMethodNodeGen.execute(InvokeMethodNodeGen.java:525)
                at <java> org.enso.interpreter.node.callable.InvokeCallableNode.invokeDynamicSymbol(InvokeCallableNode.java:286)
                at <java> org.enso.interpreter.node.callable.InvokeCallableNodeGen.executeAndSpecialize(InvokeCallableNodeGen.java:274)
                at <java> org.enso.interpreter.node.callable.InvokeCallableNodeGen.execute(InvokeCallableNodeGen.java:226)
                at <java> org.enso.interpreter.node.callable.ApplicationNode.executeGeneric(ApplicationNode.java:97)
                at <java> org.enso.interpreter.node.callable.function.BlockNode.executeGeneric(BlockNode.java:78)
                at <java> org.enso.interpreter.node.ClosureRootNode.execute(ClosureRootNode.java:85)
                at <enso> Date_Time_Formatter.format_date_time<arg-1>(Internal)
                at <enso> Panic.catch(Internal)
                at <enso> Date_Time_Formatter.handle_java_errors(Date_Time_Formatter.enso:304-306)
                at <enso> Date_Time_Formatter.format_date_time(Date_Time_Formatter.enso:328-329)
                at <enso> Date_Time.format(Date_Time.enso:968:9-36)
                at <enso> H2_JDBC_Config.with_database<arg-1>(src/H2_Spec.enso:24:51-92)
                at <enso> H2_JDBC_Config.with_database<arg-1>(src/H2_Spec.enso:24:37-93)
        """;

        var count = new AtomicInteger();
        stack.lines().forEach((line) -> {
            if (line.contains("<java>")) {
                assertTrue("Line " + line + " matches", StackLineAnalyser.matches(line));
                var link = StackLineAnalyser.analyse(line);
                assertNotNull("Link constructed for " + line, link);
                count.incrementAndGet();

                assertTrue("line ends with )", line.endsWith(")"));
                var lastColon = line.lastIndexOf(':');
                var lineNumber = Integer.parseInt(line.substring(lastColon + 1, line.length() - 1));

                assertEquals(lineNumber, link.getLineNumber());
            }
        });
        assertEquals("Few lines found", 17, count.get());
    }
}
