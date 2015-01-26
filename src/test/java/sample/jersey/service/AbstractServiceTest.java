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

import java.util.HashMap;
import java.util.Map;

import org.azkfw.jersey.test.AbstractJerseyTestCase;

/**
 * @since 1.0.0
 * @version 1.0.0 2015/01/23
 * @author kawakicchi
 */
public abstract class AbstractServiceTest extends AbstractJerseyTestCase {

	@Override
	protected Map<String, String> getInitParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("jersey.config.server.provider.packages", "sample.jersey;");
		params.put("jersey.config.server.provider.classnames", "org.glassfish.jersey.media.multipart.MultiPartFeature;org.azkfw.jersey.filter.BusinessSupportFilter;sample.jersey.handler.ExceptionHandler;");
		params.put("com.sun.jersey.spi.container.ContainerRequestFilters","org.azkfw.jersey.filter.BusinessSupportFilter");
		params.put("com.sun.jersey.spi.container.ContainerResponseFilters","org.azkfw.jersey.filter.BusinessSupportFilter");
		return params;
	}

}
