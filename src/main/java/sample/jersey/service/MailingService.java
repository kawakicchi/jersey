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

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sample.jersey.request.AbstractAuthTokenRequest;
import sample.jersey.response.AbstractResponse;

@Path("mailing")
/**
 * このクラスは、メーリング機能を提供するサービスクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class MailingService extends AbstractBusinessService {

	@POST
	@Path("send")
	/**
	 * メール送信（即時）機能
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SendResponse send(final SendRequest req) {
		SendResponse res = new SendResponse();
		try {

			setSuccess(res);

		} catch (Exception ex) {
			setSystemError(res);
		}
		return res;
	}

	/**
	 * このクラスは、メール送信（即時）リクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class SendRequest extends AbstractAuthTokenRequest {

	}

	/**
	 * このクラスは、メール送信（即時）レスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class SendResponse extends AbstractResponse {

	}
}
