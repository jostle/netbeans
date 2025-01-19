<?php
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

$anon = new class() {
    // final
    final string $final = "final";

    // final, static
    final static string $finalStatic = "final static";
    static final string $staticFinal = "final static";

    // final, abstract
    final abstract string $finalAbstract = "final static"; // final error PHP Fatal error:  Only hooked properties may be declared abstract
    abstract final string $abstractFinal = "final static"; // final error

    // final, readonly
    final readonly string $finalReadonly;
    readonly final string $readonlyFinal;
    readonly final $readonlyFinal2; // final error

    // final, visibility
    final public $finalPublic = "final visibility";
    final public string $finalPublic2 = "final visibility";
    public final string $publicFinal = "final visibility";
    final private string $finalPrivate = "final visibility"; // final error
    private final string $privateFinal = "final visibility"; // final error
    final protected string $finalProtected = "final visibility";
    protected final string $protectedFinal = "final visibility";

    // final, set visibility
    final public(set) string $finalPublicSet = "final set visibility";
    public(set) final string $finalPublicSet2 = "final set visibility";
    final public(set) $finalPublicSet3 = "final set visibility"; // final error PHP Fatal error:  Property with asymmetric visibility FinalFieldsClass::$finalPublicSet3 must have type
    final private(set) string $finalPrivateSet = "final set visibility";
    private(set) final string $finalPrivateSet2 = "final set visibility";
    final protected(set) string $finalProtectedSet = "final set visibility";
    protected(set) final string $finalProtectedSet2 = "final set visibility";

    // final, static, readonly
    final static readonly $finalStaticReadonly1; // final error
    final static readonly string $finalStaticReadonly2; // final error

    // final, static, abstract
    final abstract static $finalAbstractStatic1; // final error
    final abstract static int $finalAbstractStatic2; // final error

    // final, static, visibility
    final static public $finalStaticPublic1;
    final static public string $finalStaticPublic2;

    // final, static, set visibility
    final static public(set) $finalStaticPublicSet1; // final error
    final static public(set) string $finalStaticPublicSet2; // final error

      // final, abstract, readonly
    final abstract readonly $finalAbstractReadonly1; // error
    final abstract readonly int $finalAbstractReadonly2; // error

    // final, visibility, set visibility
    final public public(set) $finalPublicPublicSet; // final error: must have type
    final public public(set) string|int $finalPublicPublicSet1;
    final public public(set) $finalPublicPublicSet2; // final error
    final public private(set) string|int $finalPublicPrivateSet1;
    final public protected(set) string|int $finalPublicProtectedSet1;
    final private public(set) string|int $finalPrivatePublicSet1; // final error PHP Fatal error:  Property cannot be both final and private
    final private private(set) string|int $finalPrivatePrivateSet1; // final error
    final private protected(set) string|int $finalPrivateProtectedSet1; // final error
    final protected public(set) string|int $finalProtectedPublicSet1; // final error
    final protected private(set) string|int $finalProtectedPrivateSet1 = "test";
    final protected protected(set) string|int $finalProtectedProtectedSet1;

    final public(set) public string|int $finalPublicSetPublic1;
    final public(set) public $finalPublicSetPublic2; // final error
    final public(set) private string|int $finalPublicSetPrivate1; // final error
    final public(set) protected string|int $finalPublicSetProtected1; // final error
    final private(set) public string|int $finalPrivateSetPublic1;
    final private(set) private string|int $finalPrivateSetPrivate1; // final error
    final private(set) protected string|int $finalPrivateSetProtected1;
    final protected(set) public string|int $finalProtectedSetPublic1;
    final protected(set) private string|int $finalProtectedSetPrivate1; // final error
    final protected(set) protected string|int $finalProtectedSetProtected1 = 1;

    // final, visibility, set visibility readonly
    final public public(set) readonly $finalPublicPublicSetReadonlyError; // final error
    final public public(set) readonly string|int $finalPublicPublicSetReadonly;
    final public protected(set) readonly string|int $finalPublicProtectedSetReadonly;
    final public private(set) readonly string|int $finalPublicPrivateSetReadonly;
    final protected public(set) readonly string|int $finalProtectedPublicSetReadonly; // final error
    final protected protected(set) readonly string|int $finalProtectedProtectedSetReadonly;
    final protected private(set) readonly string|int $finalProtectedPrivateSetReadonly;
    final private public(set) readonly string|int $finalPrivatePublicSetReadonly; // final error
    final private protected(set) readonly string|int $finalPrivateProtectedSetReadonly; // final error
    final private private(set) readonly string|int $finalPrivatePrivateSetReadonly; // final error
};
