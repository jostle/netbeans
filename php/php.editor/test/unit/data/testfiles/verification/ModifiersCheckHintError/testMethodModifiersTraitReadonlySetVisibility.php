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

trait InvalidMethodTrait {
    // invalid modifiers
    // PHP Fatal error:  Cannot use the readonly modifier on a method
    // PHP Fatal error:  Cannot use the public(set) modifier on a method
    readonly function readonlyTraitMethodError(): void {}
//  function readonlyTraitMethodError(): void {}

    public(set) function publicSetTraitMethodError(): void {}
//  function publicSetTraitMethodError(): void {}

    private(set) function privateSetTraitMethodError(): void {}
//  function privateSetTraitMethodError(): void {}

    protected(set) function protectedSetTraitMethodError(): void {}
//  function protectedSetTraitMethodError(): void {}

    public public(set) function publicPublicSetTraitMethodError(): void {}
//  public function publicPublicSetTraitMethodError(): void {}

    public private(set) function publicPrivateSetTraitMethodError(): void {}
//  public function publicPrivateSetTraitMethodError(): void {}

    public protected(set) static function publicProtectedSetStaticTraitMethodError(): void {}
//  public function publicProtectedSetStaticTraitMethodError(): void {}
}
