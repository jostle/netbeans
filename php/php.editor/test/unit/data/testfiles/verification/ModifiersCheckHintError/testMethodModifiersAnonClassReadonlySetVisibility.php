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

// anonymous class
$anon = new class() {
    // PHP Fatal error:  Cannot use the readonly modifier on a method
    // PHP Fatal error:  Cannot use the public(set) modifier on a method
    public readonly function readonlyAnonClassMethod(): void {}
//  public function readonlyAnonClassMethod(): void {}
    public(set) function publicSetAnonClassMethod(): void {}
//  function publicSetAnonClassMethod(): void {}
    private(set) function privateSetAnonClassMethod(): void {}
//  function privateSetAnonClassMethod(): void {}
    protected(set) function protectedSetAnonClassMethod(): void {}
//  function protectedSetAnonClassMethod(): void {}
    public public(set) function publicPublicSetAnonClassMethod(): void {}
//  public function publicPublicSetAnonClassMethod(): void {}
    public private(set) static function publicPrivateSetAnonClassMethod(): void {}
//  public static function publicPrivateSetAnonClassMethod(): void {}
    public protected(set) function publicProtectedSetAnonClassMethod(): void {}
//  public function publicProtectedSetAnonClassMethod(): void {}
};
