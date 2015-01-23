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
package sample.jersey.logic;

import java.util.Map;

import org.azkfw.business.logic.Logic;

/**
 * このインターフェースは、アカウント管理機能を定義したロジックです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public interface AccountManager extends Logic {

	/**
	 * ログイン
	 * <p>
	 * 結果は下記の情報をマップで返す。
	 * <ul>
	 * <li>authToken - 認証トークン</li>
	 * <li>name - 名前</li>
	 * </ul>
	 * </p>
	 * 
	 * @param mailAddress メールアドレス
	 * @param password パスワード
	 * @return 結果。ログインできない場合、空のマップを返す。
	 */
	public Map<String, Object> login(final String mailAddress, final String password);

	/**
	 * ログアウト
	 * 
	 * @param authToken 認証トークン
	 * @return 結果
	 */
	public boolean logout(final String authToken);
}
