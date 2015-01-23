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

import java.util.HashMap;
import java.util.Map;

/**
 * このクラスは、アカウント管理機能を実装したロジックです。
 * 
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public final class AccountManagerImpl implements AccountManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.azkfw.business.logic.Logic#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.azkfw.business.logic.Logic#initialize()
	 */
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

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

}
