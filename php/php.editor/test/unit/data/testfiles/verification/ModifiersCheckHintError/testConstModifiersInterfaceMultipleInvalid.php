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

interface InvalidConstInterface {
    private public const int|string INVALID_PRIVATE_PUBLIC = 1, INVALID_PRIVATE_PUBLIC2 = 1; // error1
//  public const int|string INVALID_PRIVATE_PUBLIC = 1, INVALID_PRIVATE_PUBLIC2 = 1; // error1

    static const int INVALID_STATIC = 1; // error2
//  const int INVALID_STATIC = 1; // error2

    abstract const int INVALID_ABSTRACT = 1; // error3
//  const int INVALID_ABSTRACT = 1; // error3

    public(set) const int INVALID_SET_VISIBILITY = 1; // error4
//  const int INVALID_SET_VISIBILITY = 1; // error4

    readonly const INVALID_READONLY = 1; // error5
//  const INVALID_READONLY = 1; // error5

    public public const INVALID_MULTIPLE1 = 1; // error6
//  public const INVALID_MULTIPLE1 = 1; // error6

    final final public const INVALID_MULTIPLE2 = 1, INVALID_MULTIPLE3 = 1; // error7
//  final public const INVALID_MULTIPLE2 = 1, INVALID_MULTIPLE3 = 1; // error7

    private const int|string INVALID_PRIVATE = 1; // error8
//  const int|string INVALID_PRIVATE = 1; // error8

    protected const int|string INVALID_PROTECTED = 1; // error9
//  const int|string INVALID_PROTECTED = 1; // error9
}
