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

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sample.jersey.dto.CustomerDto;
import sample.jersey.request.AbstractAuthTokenRequest;
import sample.jersey.response.AbstractResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

@Path("customer")
/**
 * このクラスは、顧客機能を提供するサービスクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class CustomerService extends AbstractBusinessService {

	@POST
	@Path("")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerResponse customer(final CustomerRequest req) {
		CustomerResponse res = new CustomerResponse();
		try {

			setSuccess(res);

		} catch (Exception ex) {
			setSystemError(res);
		}
		return res;
	}

	@POST
	@Path("regist")
	/**
	 * 顧客登録機能
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public RegistResponse regist(final RegistRequest req) {
		RegistResponse res = new RegistResponse();
		try {

			setSuccess(res);

		} catch (Exception ex) {
			setSystemError(res);
		}
		return res;
	}

	@POST
	@Path("update")
	/**
	 * 顧客更新機能
	 * 
	 * @param req リクエスト情報
	 * @return レスポンス情報
	 */
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UpdateResponse update(final UpdateRequest req) {
		UpdateResponse res = new UpdateResponse();
		try {

			setSuccess(res);

		} catch (Exception ex) {
			setSystemError(res);
		}
		return res;
	}

	/**
	 * このクラスは、顧客取得リクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class CustomerRequest extends AbstractAuthTokenRequest {

		/** 顧客ID */
		@JsonProperty("id")
		private String customerId;

		/**
		 * コンストラクタ
		 */
		public CustomerRequest() {
			customerId = null;
		}

		/**
		 * 顧客IDを設定する。
		 * 
		 * @param id 顧客ID
		 */
		public void setCustomerId(final String id) {
			customerId = id;
		}

		/**
		 * 顧客IDを取得する。
		 * 
		 * @return 顧客ID
		 */
		public String getCustomerId() {
			return customerId;
		}
	}

	/**
	 * このクラスは、顧客取得レスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class CustomerResponse extends AbstractResponse {

		/** 顧客情報 */
		@JsonProperty("customer")
		private CustomerDto customer;

		/**
		 * コンストラクタ
		 */
		public CustomerResponse() {
			customer = null;
		}

		/**
		 * 顧客情報を設定する。
		 * 
		 * @param customer 顧客情報
		 */
		public void setCustomer(final CustomerDto customer) {
			this.customer = customer;
		}

		/**
		 * 顧客情報を取得する。
		 * 
		 * @return 顧客情報
		 */
		public CustomerDto getCustomer() {
			return customer;
		}
	}

	/**
	 * このクラスは、顧客登録リクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class RegistRequest extends AbstractAuthTokenRequest {

		/** 顧客一覧 */
		@JsonProperty("customers")
		private List<CustomerDto> customers;

		/**
		 * 顧客一覧を設定する。
		 * 
		 * @param customers 顧客一覧
		 */
		public void setCustomers(final List<CustomerDto> customers) {
			this.customers = customers;
		}

		/**
		 * 顧客一覧を取得する。
		 * 
		 * @return 顧客一覧
		 */
		public List<CustomerDto> getCustomers() {
			return customers;
		}
	}

	/**
	 * このクラスは、顧客登録レスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class RegistResponse extends AbstractResponse {

		/** 顧客一覧 */
		@JsonProperty("customers")
		private List<CustomerDto> customers;

		/**
		 * 顧客一覧を設定する。
		 * 
		 * @param customers 顧客一覧
		 */
		public void setCustomers(final List<CustomerDto> customers) {
			this.customers = customers;
		}

		/**
		 * 顧客一覧を取得する。
		 * 
		 * @return 顧客一覧
		 */
		public List<CustomerDto> getCustomers() {
			return customers;
		}
	}

	/**
	 * このクラスは、顧客更新リクエスト情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class UpdateRequest extends AbstractAuthTokenRequest {

		/** 顧客情報 */
		@JsonProperty("customer")
		private CustomerDto customer;

		/**
		 * コンストラクタ
		 */
		public UpdateRequest() {
			customer = null;
		}

		/**
		 * 顧客情報を設定する。
		 * 
		 * @param customer 顧客情報
		 */
		public void setCustomer(final CustomerDto customer) {
			this.customer = customer;
		}

		/**
		 * 顧客情報を取得する。
		 * 
		 * @return 顧客情報
		 */
		public CustomerDto getCustomer() {
			return customer;
		}
	}

	/**
	 * このクラスは、顧客更新レスポンス情報を保持するクラスです。
	 * 
	 * @since 1.0.0
	 * @version 1.0.0 2015/01/23
	 * @author kawakicchi
	 */
	public final static class UpdateResponse extends AbstractResponse {

		/** 顧客情報 */
		@JsonProperty("customer")
		private CustomerDto customer;

		/**
		 * コンストラクタ
		 */
		public UpdateResponse() {
			customer = null;
		}

		/**
		 * 顧客情報を設定する。
		 * 
		 * @param customer 顧客情報
		 */
		public void setCustomer(final CustomerDto customer) {
			this.customer = customer;
		}

		/**
		 * 顧客情報を取得する。
		 * 
		 * @return 顧客情報
		 */
		public CustomerDto getCustomer() {
			return customer;
		}
	}

}
