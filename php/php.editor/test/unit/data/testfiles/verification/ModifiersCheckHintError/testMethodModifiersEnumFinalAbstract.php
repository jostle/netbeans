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

enum InvalidMethodEnum {
    // PHP Fatal error:  Cannot use the final modifier on an abstract method
    final abstract function finalAbstractEnumMethod(): void {} // method error enum
//  final function finalAbstractEnumMethod(): void {} // method error enum

    final abstract public function finalAbstractPublicEnumMethod(): void {} // method error enum
//  final public function finalAbstractPublicEnumMethod(): void {} // method error enum

    final abstract protected function finalAbstractProtectedEnumMethod(): void {} // method error enum
//  final protected function finalAbstractProtectedEnumMethod(): void {} // method error enum

    final abstract private function finalAbstractPrivateEnumMethod(): void {} // method error enum
//  final private function finalAbstractPrivateEnumMethod(): void {} // method error enum
}
