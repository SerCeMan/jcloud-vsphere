/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jclouds.vsphere.api

import com.vmware.vim25.ComplianceResult
import com.vmware.vim25.ProfileExpressionMetadata
import com.vmware.vim25.RuntimeFault
import com.vmware.vim25.mo.ManagedEntity
import com.vmware.vim25.mo.Profile
import com.vmware.vim25.mo.Task

import java.rmi.RemoteException

interface ProfileComplianceManagerApi {
    @Throws(RuntimeFault::class, RemoteException::class)
    fun checkComplianceTask(profile: List<Profile>, entity: List<ManagedEntity>): Task

    @Throws(RuntimeFault::class, RemoteException::class)
    fun clearComplianceStatus(profile: List<Profile>, entity: List<ManagedEntity>)

    @Throws(RuntimeFault::class, RemoteException::class)
    fun queryComplianceStatus(profile: List<Profile>, entity: List<ManagedEntity>): List<ComplianceResult>

    /**
     * SDK4.1 signature for back compatibility
     */
    @Throws(RuntimeFault::class, RemoteException::class)
    fun queryExpressionMetadata(expressionName: List<String>): List<ProfileExpressionMetadata>

    /**
     * SDK5.0 signature
     */
    @Throws(RuntimeFault::class, RemoteException::class)
    fun queryExpressionMetadata(expressionName: List<String>, profile: Profile): List<ProfileExpressionMetadata>
}
