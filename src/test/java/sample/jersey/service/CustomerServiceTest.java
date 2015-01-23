/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.jersey.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Test;

import sample.jersey.service.CustomerService.CustomerRequest;
import sample.jersey.service.CustomerService.CustomerResponse;
import sample.jersey.service.CustomerService.RegistRequest;
import sample.jersey.service.CustomerService.RegistResponse;
import sample.jersey.service.CustomerService.UpdateRequest;
import sample.jersey.service.CustomerService.UpdateResponse;

/**
 * このクラスは、{@link CustomerService}の評価を行う。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class CustomerServiceTest extends AbstractServiceTest {

	@Override
	protected List<Class<?>> getTestClasses() {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(CustomerService.class);
		return classes;
	}

	@Test
	public void customer() {
		CustomerRequest req = new CustomerRequest();
		Entity<CustomerRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/customer", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		CustomerResponse res = response.readEntity(CustomerResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());
	}

	@Test
	public void regist() {
		RegistRequest req = new RegistRequest();
		Entity<RegistRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/customer/regist", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		RegistResponse res = response.readEntity(RegistResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());
	}

	@Test
	public void update() {
		UpdateRequest req = new UpdateRequest();
		Entity<UpdateRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/customer/update", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		UpdateResponse res = response.readEntity(UpdateResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());
	}

}
