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

import sample.jersey.service.MailingService.SendRequest;
import sample.jersey.service.MailingService.SendResponse;

/**
 * このクラスは、{@link MailingService}の評価を行う。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class MailingServiceTest extends AbstractServiceTest {

	@Override
	protected List<Class<?>> getTestClasses() {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		classes.add(MailingService.class);
		return classes;
	}

	@Test
	public void send() {
		SendRequest req = new SendRequest();
		Entity<SendRequest> e = Entity.entity(req, MediaType.APPLICATION_JSON_TYPE);

		Response response = post("/mailing/send", e);

		assertEquals("HTTPステータス", 200, response.getStatus());

		SendResponse res = response.readEntity(SendResponse.class);
		assertEquals("結果", 0, res.getResultCode());
		assertNull("エラーコード", res.getErrorCode());
		assertNull("エラーメッセージ", res.getErrorMessage());
	}
}
