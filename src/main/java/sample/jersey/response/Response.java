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
package sample.jersey.response;

/**
 * このインターフェースは、レスポンス機能を定義したインターフェースです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public interface Response {

	/** 結果(成功) */
	public final static int SUCCESS = 0;

	/** 結果(失敗) */
	public final static int ERROR = 1;

	/**
	 * 結果コードを設定する。
	 * 
	 * @param code コード
	 */
	public void setResultCode(final int code);

	/**
	 * 結果コードを取得する。
	 * 
	 * @return コード
	 */
	public int getResultCode();

	/**
	 * エラーコードを設定する。
	 * 
	 * @param code コード
	 */
	public void setErrorCode(final Integer code);

	/**
	 * エラーコードを取得する。
	 * 
	 * @return コード
	 */
	public Integer getErrorCode();

	/**
	 * エラーメッセージを設定する。
	 * 
	 * @param message メッセージ
	 */
	public void setErrorMessage(final String message);

	/**
	 * エラーメッセージを取得する。
	 * 
	 * @return メッセージ
	 */
	public String getErrorMessage();
}