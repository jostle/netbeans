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
    // PHP Fatal error:  Multiple final modifiers are not allowed
    final final function finalFinalAnonClassMethod(): void {}
//  final function finalFinalAnonClassMethod(): void {}

    public public function publicPublicAnonClassMethod(): void {}
//  public function publicPublicAnonClassMethod(): void {}

    public private function publicPrivateAnonClassMethod(): void {}
//  private function publicPrivateAnonClassMethod(): void {}
//  public function publicPrivateAnonClassMethod(): void {}

    public protected function publicProtectedAnonClassMethod(): void {}
//  protected function publicProtectedAnonClassMethod(): void {}
//  public function publicProtectedAnonClassMethod(): void {}

    public static static function staticStaticAnonClassMethod(): void {}
//  public static function staticStaticAnonClassMethod(): void {}
};
