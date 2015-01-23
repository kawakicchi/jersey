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
package sample.jersey.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * このクラスは、顧客情報を保持するクラスです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
// @JsonIgnoreProperties(ignoreUnknown = true) // JSON->DTO変換時にパラメータが存在しないものを許容する
// @JsonIgnoreProperties(ignoreUnknown = true, value = { "id" }) // JSON->DTO変換時にパラメータが存在しないものを許容する、idは出力しない
// @JsonInclude(Include.NON_NULL) // DTO->JSON変換時にnullのものは出力しない
public final class CustomerDto {

	/** 顧客ID */
	@JsonProperty("id")
	private String customerId;

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
