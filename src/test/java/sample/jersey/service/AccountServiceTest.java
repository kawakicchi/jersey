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

import sample.jersey.service.AccountService.LoginRequest;
import sample.jersey.service.AccountService.LoginResponse;
import sample.jersey.service.AccountService.LogoutRequest;
import sample.jersey.service.AccountService.LogoutResponse;
import sample.jersey.service.AccountService.RegistRequest;
import sample.jersey.service.AccountService.RegistResponse;

/**
 * このクラスは、{@link AccountService}の評価を行う。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class AccountServiceTest extends AbstractServiceTest {

	@Override
	protected List<Class<?>> getTestClasses() {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(AccountService.class);
		return classes;
	}

	@Test
	public void login() {
		LoginRequest req = new LoginRequest();
		Entity<LoginRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/account/login", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		LoginResponse res = response.readEntity(LoginResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());

		assertEquals("12345678901234567890123456789012", res.getAuthToken());
		assertEquals("名前", res.getName());
	}

	@Test
	public void logout() {
		LogoutRequest req = new LogoutRequest();
		Entity<LogoutRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/account/logout", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		LogoutResponse res = response.readEntity(LogoutResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());
	}

	@Test
	public void regist() {
		RegistRequest req = new RegistRequest();
		Entity<RegistRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/account/regist", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		RegistResponse res = response.readEntity(RegistResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());
	}

	@Test
	public void activate() {
		Response response = get("/account/activate/aaaaaaaaaabbbbbbbbbbccccccccccdd");

		assertEquals("HTTPステータス", 200, response.getStatus());

		System.out.println(response.readEntity(String.class));
	}

}
