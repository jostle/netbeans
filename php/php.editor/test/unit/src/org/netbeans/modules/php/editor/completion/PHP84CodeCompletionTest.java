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
package org.netbeans.modules.php.editor.completion;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.modules.php.project.api.PhpSourcePath;
import org.netbeans.spi.java.classpath.support.ClassPathSupport;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

public class PHP84CodeCompletionTest extends PHPCodeCompletionTestBase {

    public PHP84CodeCompletionTest(String testName) {
        super(testName);
    }

    @Override
    protected Map<String, ClassPath> createClassPathsForTest() {
        List<FileObject> classPaths = new ArrayList<>();
        classPaths.add(FileUtil.toFileObject(new File(getDataDir(), "/testfiles/completion/lib/php84/" + getTestDirName())));
        String name = getName();
        if (name.startsWith("testNewWithoutParenthesesTyping")) {
            classPaths.add(FileUtil.toFileObject(new File(getDataDir(), "/testfiles/completion/lib/php84/_classes")));
        }
        return Collections.singletonMap(
                PhpSourcePath.SOURCE_CP,
                ClassPathSupport.createClassPath(classPaths.toArray(new FileObject[0]))
        );
    }

    private String getTestPath() {
        return String.format("testfiles/completion/lib/php84/%s/%s.php", getTestDirName(), getTestDirName());
    }

    private void checkCompletion(String caretPosition) throws Exception {
        checkCompletion(getTestPath(), caretPosition, false);
    }

    public void testNewWithoutParentheses_01a() throws Exception {
        checkCompletion("        echo new Test()->^publicTestMethod();");
    }

    public void testNewWithoutParentheses_01b() throws Exception {
        checkCompletion("        echo new Test()->public^TestMethod();");
    }

    public void testNewWithoutParentheses_01c() throws Exception {
        checkCompletion("        echo new Test()->publicTestMe^thod();");
    }

    public void testNewWithoutParentheses_02a() throws Exception {
        checkCompletion("        echo new Test()::^publicStaticTestMethod();");
    }

    public void testNewWithoutParentheses_02b() throws Exception {
        checkCompletion("        echo new Test()::publicStaticTest^Method();");
    }

    public void testNewWithoutParentheses_03a() throws Exception {
        checkCompletion("        $example = new Example()->^publicMethod();");
    }

    public void testNewWithoutParentheses_03b() throws Exception {
        checkCompletion("        $example = new Example()->publicM^ethod();");
    }

    public void testNewWithoutParentheses_04a() throws Exception {
        checkCompletion("        $example = new Example()::^IMPLICIT_PUBLIC_CONST;");
    }

    public void testNewWithoutParentheses_04b() throws Exception {
        checkCompletion("        $example = new Example()::IMPLICIT_P^UBLIC_CONST;");
    }

    public void testNewWithoutParentheses_05a() throws Exception {
        checkCompletion("        $example = new Example()->^returnThis()?->privateField;");
    }

    public void testNewWithoutParentheses_05b() throws Exception {
        checkCompletion("        $example = new Example()->retur^nThis()?->privateField;");
    }

    public void testNewWithoutParentheses_05c() throws Exception {
        checkCompletion("        $example = new Example()->returnThis()?->^privateField;");
    }

    public void testNewWithoutParentheses_05d() throws Exception {
        checkCompletion("        $example = new Example()->returnThis()?->privateF^ield;");
    }

    public void testNewWithoutParentheses_06a() throws Exception {
        checkCompletion("        $example = new Example()->^returnThis()->publicMethod();");
    }

    public void testNewWithoutParentheses_06b() throws Exception {
        checkCompletion("        $example = new Example()->returnTh^is()->publicMethod();");
    }

    public void testNewWithoutParentheses_06c() throws Exception {
        checkCompletion("        $example = new Example()->returnThis()->^publicMethod();");
    }

    public void testNewWithoutParentheses_06d() throws Exception {
        checkCompletion("        $example = new Example()->returnThis()->publicMe^thod();");
    }

    public void testNewWithoutParentheses_07a() throws Exception {
        checkCompletion("        $example = new Example()->^returnThis()::$protectedStaticField;");
    }

    public void testNewWithoutParentheses_07b() throws Exception {
        checkCompletion("        $example = new Example()->retur^nThis()::$protectedStaticField;");
    }

    public void testNewWithoutParentheses_07c() throws Exception {
        checkCompletion("        $example = new Example()->returnThis()::^$protectedStaticField;");
    }

    public void testNewWithoutParentheses_07d() throws Exception {
        checkCompletion("        $example = new Example()->returnThis()::$protectedStati^cField;");
    }

    public void testNewWithoutParentheses_08a() throws Exception {
        checkCompletion("        $example = new Example()?->^returnThis()::PRIVATE_CONST;");
    }

    public void testNewWithoutParentheses_08b() throws Exception {
        checkCompletion("        $example = new Example()?->retur^nThis()::PRIVATE_CONST;");
    }

    public void testNewWithoutParentheses_08c() throws Exception {
        checkCompletion("        $example = new Example()?->returnThis()::^PRIVATE_CONST;");
    }

    public void testNewWithoutParentheses_08d() throws Exception {
        checkCompletion("        $example = new Example()?->returnThis()::PRIVATE_CON^ST;");
    }

    public void testNewWithoutParentheses_09a() throws Exception {
        checkCompletion("        $example = new Example()->^test->publicTestField;");
    }

    public void testNewWithoutParentheses_09b() throws Exception {
        checkCompletion("        $example = new Example()->te^st->publicTestField;");
    }

    public void testNewWithoutParentheses_09c() throws Exception {
        checkCompletion("        $example = new Example()->test->^publicTestField;");
    }

    public void testNewWithoutParentheses_09d() throws Exception {
        checkCompletion("        $example = new Example()->test->publicTest^Field;");
    }

    public void testNewWithoutParentheses_10a() throws Exception {
        checkCompletion("        $example = new Example()?->^test->publicTestMethod();");
    }

    public void testNewWithoutParentheses_10b() throws Exception {
        checkCompletion("        $example = new Example()?->tes^t->publicTestMethod();");
    }

    public void testNewWithoutParentheses_10c() throws Exception {
        checkCompletion("        $example = new Example()?->test->^publicTestMethod();");
    }

    public void testNewWithoutParentheses_10d() throws Exception {
        checkCompletion("        $example = new Example()?->test->publicTe^stMethod();");
    }

    public void testNewWithoutParentheses_11a() throws Exception {
        checkCompletion("        $example = new Example()->^test::PUBLIC_TEST_CONST;");
    }

    public void testNewWithoutParentheses_11b() throws Exception {
        checkCompletion("        $example = new Example()->te^st::PUBLIC_TEST_CONST;");
    }

    public void testNewWithoutParentheses_11c() throws Exception {
        checkCompletion("        $example = new Example()->test::^PUBLIC_TEST_CONST;");
    }

    public void testNewWithoutParentheses_11d() throws Exception {
        checkCompletion("        $example = new Example()->test::PUBLIC_TES^T_CONST;");
    }

    public void testNewWithoutParentheses_12a() throws Exception {
        checkCompletion("new Example()->^publicField; // test");
    }

    public void testNewWithoutParentheses_12b() throws Exception {
        checkCompletion("new Example()->publicFie^ld; // test");
    }

    public void testNewWithoutParentheses_13a() throws Exception {
        checkCompletion("new Example()::^$publicStaticField; // test");
    }

    public void testNewWithoutParentheses_13b() throws Exception {
        checkCompletion("new Example()::$publicStatic^Field; // test");
    }

    public void testNewWithoutParentheses_14a() throws Exception {
        checkCompletion("new Example()?->^returnThis()?->publicMethod(); // test");
    }

    public void testNewWithoutParentheses_14b() throws Exception {
        checkCompletion("new Example()?->return^This()?->publicMethod(); // test");
    }

    public void testNewWithoutParentheses_14c() throws Exception {
        checkCompletion("new Example()?->returnThis()?->^publicMethod(); // test");
    }

    public void testNewWithoutParentheses_14d() throws Exception {
        checkCompletion("new Example()?->returnThis()?->public^Method(); // test");
    }

    public void testNewWithoutParentheses_15a() throws Exception {
        checkCompletion("new Example()->^returnThis()::publicStaticMethod(); // test");
    }

    public void testNewWithoutParentheses_15b() throws Exception {
        checkCompletion("new Example()->return^This()::publicStaticMethod(); // test");
    }

    public void testNewWithoutParentheses_15c() throws Exception {
        checkCompletion("new Example()->returnThis()::^publicStaticMethod(); // test");
    }

    public void testNewWithoutParentheses_15d() throws Exception {
        checkCompletion("new Example()->returnThis()::publicStaticMe^thod(); // test");
    }

    public void testNewWithoutParentheses_16a() throws Exception {
        checkCompletion("new Example()->^test?->publicTestField; // test");
    }

    public void testNewWithoutParentheses_16b() throws Exception {
        checkCompletion("new Example()->tes^t?->publicTestField; // test");
    }

    public void testNewWithoutParentheses_16c() throws Exception {
        checkCompletion("new Example()->test?->^publicTestField; // test");
    }

    public void testNewWithoutParentheses_16d() throws Exception {
        checkCompletion("new Example()->test?->publicTes^tField; // test");
    }

    public void testNewWithoutParentheses_17a() throws Exception {
        checkCompletion("new Example()->^test->publicTestMethod(); // test");
    }

    public void testNewWithoutParentheses_17b() throws Exception {
        checkCompletion("new Example()->te^st->publicTestMethod(); // test");
    }

    public void testNewWithoutParentheses_17c() throws Exception {
        checkCompletion("new Example()->test->^publicTestMethod(); // test");
    }

    public void testNewWithoutParentheses_17d() throws Exception {
        checkCompletion("new Example()->test->publicTestMet^hod(); // test");
    }

    public void testNewWithoutParentheses_18a() throws Exception {
        checkCompletion("new Example()?->^test::PUBLIC_TEST_CONST; // test");
    }

    public void testNewWithoutParentheses_18b() throws Exception {
        checkCompletion("new Example()?->tes^t::PUBLIC_TEST_CONST; // test");
    }

    public void testNewWithoutParentheses_18c() throws Exception {
        checkCompletion("new Example()?->test::^PUBLIC_TEST_CONST; // test");
    }

    public void testNewWithoutParentheses_18d() throws Exception {
        checkCompletion("new Example()?->test::PUBLIC_TEST^_CONST; // test");
    }

    public void testNewWithoutParentheses_19a() throws Exception {
        checkCompletion("new Example()->^test::$publicStaticTestField; // test");
    }

    public void testNewWithoutParentheses_19b() throws Exception {
        checkCompletion("new Example()->tes^t::$publicStaticTestField; // test");
    }

    public void testNewWithoutParentheses_19c() throws Exception {
        checkCompletion("new Example()->test::^$publicStaticTestField; // test");
    }

    public void testNewWithoutParentheses_19d() throws Exception {
        checkCompletion("new Example()->test::$publicStatic^TestField; // test");
    }

    public void testNewWithoutParentheses_20a() throws Exception {
        checkCompletion("}::^PUBLIC_CONSTANT;");
    }

    public void testNewWithoutParentheses_20b() throws Exception {
        checkCompletion("}::PUBLIC_CONST^ANT;");
    }

    public void testNewWithoutParentheses_21a() throws Exception {
        checkCompletion("}->^publicField2;");
    }

    public void testNewWithoutParentheses_21b() throws Exception {
        checkCompletion("}->publicFie^ld2;");
    }

    public void testNewWithoutParentheses_22a() throws Exception {
        checkCompletion("}::^publicStaticMethod3()->publicMethod3()->publicField3;");
    }

    public void testNewWithoutParentheses_22b() throws Exception {
        checkCompletion("}::publicStati^cMethod3()->publicMethod3()->publicField3;");
    }

    public void testNewWithoutParentheses_22c() throws Exception {
        checkCompletion("}::publicStaticMethod3()->^publicMethod3()->publicField3;");
    }

    public void testNewWithoutParentheses_22d() throws Exception {
        checkCompletion("}::publicStaticMethod3()->publicMet^hod3()->publicField3;");
    }

    public void testNewWithoutParentheses_22e() throws Exception {
        checkCompletion("}::publicStaticMethod3()->publicMethod3()->publi^cField3;");
    }

    public void testNewWithoutParentheses_23a() throws Exception {
        checkCompletion("}->^publicMethod4()::publicStaticMethod4()->publicField4;");
    }

    public void testNewWithoutParentheses_23b() throws Exception {
        checkCompletion("}->publicMe^thod4()::publicStaticMethod4()->publicField4;");
    }

    public void testNewWithoutParentheses_23c() throws Exception {
        checkCompletion("}->publicMethod4()::^publicStaticMethod4()->publicField4;");
    }

    public void testNewWithoutParentheses_23d() throws Exception {
        checkCompletion("}->publicMethod4()::publicStat^icMethod4()->publicField4;");
    }

    public void testNewWithoutParentheses_23e() throws Exception {
        checkCompletion("}->publicMethod4()::publicStaticMethod4()->public^Field4;");
    }

    public void testNewWithoutParentheses_24a() throws Exception {
        checkCompletion("}->^publicMethod5()::publicStaticTestMethod5();");
    }

    public void testNewWithoutParentheses_24b() throws Exception {
        checkCompletion("}->publicM^ethod5()::publicStaticTestMethod5();");
    }

    public void testNewWithoutParentheses_24c() throws Exception {
        checkCompletion("}->publicMethod5()::^publicStaticTestMethod5();");
    }

    public void testNewWithoutParentheses_24d() throws Exception {
        checkCompletion("}->publicMethod5()::publicStaticTe^stMethod5();");
    }

    public void testNewWithoutParentheses_25a() throws Exception {
        checkCompletion("        }::^publicStaticMethod6();");
    }

    public void testNewWithoutParentheses_25b() throws Exception {
        checkCompletion("        }::publicStaticMe^thod6();");
    }

    public void testNewWithoutParentheses_26a() throws Exception {
        checkCompletion("        }->^publicMethod7()::publicStaticTestMethod7();");
    }

    public void testNewWithoutParentheses_26b() throws Exception {
        checkCompletion("        }->publicMet^hod7()::publicStaticTestMethod7();");
    }

    public void testNewWithoutParentheses_26c() throws Exception {
        checkCompletion("        }->publicMethod7()::^publicStaticTestMethod7();");
    }

    public void testNewWithoutParentheses_26d() throws Exception {
        checkCompletion("        }->publicMethod7()::publicStaticTes^tMethod7();");
    }

    public void testNewWithoutParenthesesTyping01() throws Exception {
        checkCompletion("new Test()::^");
    }

    public void testNewWithoutParenthesesTyping02() throws Exception {
        checkCompletion("new Test()::public^");
    }

    public void testNewWithoutParenthesesTyping03() throws Exception {
        checkCompletion("new Test()->^");
    }

    public void testNewWithoutParenthesesTyping04() throws Exception {
        checkCompletion("new Test()->publicTe^");
    }

    public void testNewWithoutParenthesesTyping05() throws Exception {
        checkCompletion("        $example = new Example()->^");
    }

    public void testNewWithoutParenthesesTyping06() throws Exception {
        checkCompletion("        $example = new Example()->priva^");
    }

    public void testNewWithoutParenthesesTyping07() throws Exception {
        checkCompletion("        $example = new Example()::^");
    }

    public void testNewWithoutParenthesesTyping08() throws Exception {
        checkCompletion("        $example = new Example()::public^");
    }

    public void testNewWithoutParenthesesTyping09() throws Exception {
        checkCompletion("        $example = new Example()->test->^");
    }

    public void testNewWithoutParenthesesTyping10() throws Exception {
        checkCompletion("        $example = new Example()->test->publicTe^");
    }

    public void testNewWithoutParenthesesTyping11() throws Exception {
        checkCompletion("        $example = new Example()->test::^");
    }

    public void testNewWithoutParenthesesTyping12() throws Exception {
        checkCompletion("        $example = new Example()->test::public^");
    }

    public void testNewWithoutParenthesesAnonTyping01() throws Exception {
        checkCompletion("}::^;");
    }

    public void testNewWithoutParenthesesAnonTyping02() throws Exception {
        checkCompletion("}->^;");
    }

    public void testNewWithoutParenthesesAnonTyping03() throws Exception {
        checkCompletion("}?->^;");
    }

    // TODO: add tests for typing anonymous class without ";"
    // e.g.
    // echo new class() {
    //     public const string CONSTANT = "constant";
    // }::^
    // in the above case, the statement is broken (it has a syntax error)
    // so, the anonymous class is not parsed correctly i.e. we can't get members
    // we have to sanitize an error part
}
