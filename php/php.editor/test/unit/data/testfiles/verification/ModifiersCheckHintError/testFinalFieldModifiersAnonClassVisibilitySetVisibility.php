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
    // final, visibility, set visibility
    final public public(set) $finalPublicPublicSet; // error1: must have type
    final public public(set) string|int $finalPublicPublicSet1;
    final public public(set) $finalPublicPublicSet2; // error2
    final public private(set) string|int $finalPublicPrivateSet1;
    final public protected(set) string|int $finalPublicProtectedSet1;

    final private public(set) string|int $finalPrivatePublicSet1; // error3 fix1 PHP Fatal error:  Property cannot be both final and private
//  private public(set) string|int $finalPrivatePublicSet1; // error3 fix1 PHP Fatal error:  Property cannot be both final and private
//  final public(set) string|int $finalPrivatePublicSet1; // error3 fix1 PHP Fatal error:  Property cannot be both final and private

    final private private(set) string|int $finalPrivatePrivateSet1; // error4 fix2
//  private private(set) string|int $finalPrivatePrivateSet1; // error4 fix2
//  final private(set) string|int $finalPrivatePrivateSet1; // error4 fix2

    final private protected(set) string|int $finalPrivateProtectedSet1; // error5 fix3
//  private protected(set) string|int $finalPrivateProtectedSet1; // error5 fix3
//  final protected(set) string|int $finalPrivateProtectedSet1; // error5 fix3

    final protected public(set) string|int $finalProtectedPublicSet1; // error6
    final protected private(set) string|int $finalProtectedPrivateSet1 = "test";
    final protected protected(set) string|int $finalProtectedProtectedSet1;

    final public(set) public string|int $finalPublicSetPublic1;
    final public(set) public $finalPublicSetPublic2; // error7

    final public(set) private string|int $finalPublicSetPrivate1; // error8 fix4
//  public(set) private string|int $finalPublicSetPrivate1; // error8 fix4
//  final public(set) string|int $finalPublicSetPrivate1; // error8 fix4

    final public(set) protected string|int $finalPublicSetProtected1; // error9
    final private(set) public string|int $finalPrivateSetPublic1;

    final private(set) private string|int $finalPrivateSetPrivate1; // error10 fix5
//  private(set) private string|int $finalPrivateSetPrivate1; // error10 fix5
//  final private(set) string|int $finalPrivateSetPrivate1; // error10 fix5

    final private(set) protected string|int $finalPrivateSetProtected1;
    final protected(set) public string|int $finalProtectedSetPublic1;

    final protected(set) private string|int $finalProtectedSetPrivate1; // error11 fix6
//  protected(set) private string|int $finalProtectedSetPrivate1; // error11 fix6
//  final protected(set) string|int $finalProtectedSetPrivate1; // error11 fix6

    final protected(set) protected string|int $finalProtectedSetProtected1 = 1;
};
