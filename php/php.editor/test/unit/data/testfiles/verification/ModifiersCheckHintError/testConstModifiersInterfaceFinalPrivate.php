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

interface FinalPrivateConstant
{
    #[Attr("attribute")]
    final private const PRIVATE_CONST1 = "foo"; // error1
//  final const PRIVATE_CONST1 = "foo"; // error1

    private final const PRIVATE_CONST2 = "foo"; // error2
//  final const PRIVATE_CONST2 = "foo"; // error2

    final private const PRIVATE_CONST3 = "foo", PRIVATE_CONST4 = "foo"; // error3
//  final const PRIVATE_CONST3 = "foo", PRIVATE_CONST4 = "foo"; // error3

    #[Attr("attribute")]
    private final const PRIVATE_CONST5 = "foo", PRIVATE_CONST6 = "foo"; // error4
//  final const PRIVATE_CONST5 = "foo", PRIVATE_CONST6 = "foo"; // error4

    final private const string|int PRIVATE_CONST_TYPE_1 = "foo"; // error5
//  final const string|int PRIVATE_CONST_TYPE_1 = "foo"; // error5

    private final const string|int PRIVATE_CONST_TYPE_2 = "foo"; // error6
//  final const string|int PRIVATE_CONST_TYPE_2 = "foo"; // error6

    #[Attr("attribute")]
    final private const string|int PRIVATE_CONST_TYPE_3 = "foo", PRIVATE_CONST_TYPE_4 = "foo"; // error7
//  final const string|int PRIVATE_CONST_TYPE_3 = "foo", PRIVATE_CONST_TYPE_4 = "foo"; // error7

    private final const string|int PRIVATE_CONST_TYPE_5 = "foo", PRIVATE_CONST_TYPE_6 = "foo"; // error8
//  final const string|int PRIVATE_CONST_TYPE_5 = "foo", PRIVATE_CONST_TYPE_6 = "foo"; // error8
}
