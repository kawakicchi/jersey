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

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.azkfw.biz.crypto.Crypto;
import org.azkfw.biz.crypto.CryptoFactory;
import org.azkfw.business.dao.DataAccessServiceException;
import org.azkfw.business.logic.AbstractDynamicSQLLogic;
import org.azkfw.dsql.Parameter;
import org.azkfw.util.DateUtility;
import org.azkfw.util.UUIDUtility;

/**
 * このクラスは、アカウント管理機能を実装したロジックです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class AccountManagerImpl extends AbstractDynamicSQLLogic implements AccountManager {

	@Override
	public void doDestroy() {
	}

	@Override
	public void doInitialize() {
	}

	@Override
	public Map<String, Object> login(final String mailAddress, final String password) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("authToken", "12345678901234567890123456789012");
		result.put("name", "名前");
		return result;
	}

	@Override
	public boolean logout(final String authToken) {
		return true;
	}

	public Map<String, Object> regist(final String name, final String email, final String password) {
		Map<String, Object> result = new HashMap<String, Object>();

		Date date = new Date();
		Timestamp createDate = new Timestamp((date).getTime());
		Timestamp periodDate = new Timestamp(DateUtility.getDayOfAddDay(date, 1).getTime());

		String accountId = UUIDUtility.generateToShortString();
		String token = UUIDUtility.generateToShortString();

		Crypto crypto = CryptoFactory.createAES("XxxMUCHUMUCHUxxX", "xXxMUCHUMUCHUxXx");
		String cryPass = crypto.encrypt(password);

		Parameter params = new Parameter();
		params.put("accountId", accountId);
		params.put("name", name);
		params.put("email", email);
		params.put("password", cryPass);
		params.put("token", token);
		params.put("periodDate", periodDate);
		params.put("createDate", createDate);

		try {
			getDao("AccountManagerI01", params).execute();
			commit();

			result.put("token", token);

		} catch (DataAccessServiceException ex) {
			try {
				rollback();
			} catch (SQLException ex2) {

			}
		} catch (SQLException ex) {
			try {
				rollback();
			} catch (SQLException ex2) {

			}
		}

		return result;
	}

	@Override
	public Map<String, Object> activate(final String token) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("authToken", "12345678901234567890123456789012");
		result.put("name", "名前");
		return result;
	}

}
