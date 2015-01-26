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

import org.azkfw.jersey.service.AbstractBusinessService;

import sample.jersey.response.Response;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/01/24
 * @author Kawakicchi
 */
public abstract class AbstractBaseService extends AbstractBusinessService {

	/**
	 * コンストラクタ
	 * 
	 * @param name 名前
	 */
	public AbstractBaseService(final String name) {
		super(name);
	}

	/**
	 * コンストラクタ
	 * 
	 * @param clazz クラス
	 */
	public AbstractBaseService(final Class<?> clazz) {
		super(clazz);
	}

	/**
	 * レスポンス情報に成功情報を設定する。
	 * 
	 * @param response レスポンス情報
	 * @return レスポンス情報
	 */
	protected final <T extends Response> T setSuccess(final T response) {
		response.setResultCode(Response.SUCCESS);
		response.setErrorCode(null);
		response.setErrorMessage(null);
		return response;
	}

	/**
	 * レスポンス情報にエラー情報を設定する。
	 * 
	 * @param response レスポンス情報
	 * @param code エラーコード
	 * @param message エラーメッセージ
	 * @return レスポンス情報
	 */
	protected final <T extends Response> T setError(final T response, final int code, final String message) {
		response.setResultCode(Response.ERROR);
		response.setErrorCode(code);
		response.setErrorMessage(message);
		return response;
	}

	/**
	 * レスポンス情報にシステムエラー情報を設定する。
	 * 
	 * @param response レスポンス情報
	 * @return レスポンス情報
	 */
	protected final <T extends Response> T setSystemError(final T response) {
		response.setResultCode(Response.ERROR);
		response.setErrorCode(-1);
		response.setErrorMessage("System error.");
		return response;
	}
}
