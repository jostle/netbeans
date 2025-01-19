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

abstract class InvalidMethodClass {
    // invalid modifiers
    // PHP Fatal error:  Cannot use the readonly modifier on a method
    // PHP Fatal error:  Cannot use the public(set) modifier on a method
    readonly function readonlyClassMethod(): void {} // method error class
//  function readonlyClassMethod(): void {} // method error class

    public(set) function publicSetClassMethod(): void {} // method error class
//  function publicSetClassMethod(): void {} // method error class

    private(set) function privateSetClassMethod(): void {} // method error class
//  function privateSetClassMethod(): void {} // method error class

    protected(set) function protectedSetClassMethod(): void {} // method error class
//  function protectedSetClassMethod(): void {} // method error class

    public public(set) function publicPublicSetClassMethod(): void {} // method error class
//  public function publicPublicSetClassMethod(): void {} // method error class

    public private(set) function publicPrivateSetClassMethod(): void {} // method error class
//  public function publicPrivateSetClassMethod(): void {} // method error class

    public protected(set) function publicProtectedSetClassMethod(): void {} // method error class
//  public function publicProtectedSetClassMethod(): void {} // method error class
}
