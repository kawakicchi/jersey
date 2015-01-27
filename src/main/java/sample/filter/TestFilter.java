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
package sample.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.message.internal.MediaTypes;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.glassfish.jersey.server.ContainerRequest;

public class TestFilter implements ContainerRequestFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {

		String method = requestContext.getMethod();
		if ("POST".equals(method)) {
			ContainerRequest r = (ContainerRequest) requestContext.getRequest();

			if (MediaTypes.typeEqual(MediaType.APPLICATION_JSON_TYPE, requestContext.getMediaType())) {
				// Media application/json
				if (!r.bufferEntity()) {
					System.out.println("----------------------------------------------------");					
					// warn("Unsupported buffer entity.");
				}

				// TODO: write code
				// AuthToken authToken = r.readEntity(AuthToken.class);
				// if (null != authToken) {
				//	token.getAuthToken();
				// }

				r.getEntityStream().reset(); // 次のフィルター使用する場合、リセットされていない為

			} else if (MediaTypes.typeEqual(MediaType.MULTIPART_FORM_DATA_TYPE, requestContext.getMediaType())) {
				// Media multipart/form-data
				InputStream in = r.getEntityStream();
				if (in.getClass() != ByteArrayInputStream.class) {
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ReaderWriter.writeTo(in, baos);
					in = new ByteArrayInputStream(baos.toByteArray());
					requestContext.setEntityStream(in);
				}

				MultivaluedMap<String, String> map = new MultivaluedHashMap<String, String>();

				FormDataMultiPart form = r.readEntity(FormDataMultiPart.class);
				Map<String, List<FormDataBodyPart>> m = form.getFields();
				for (String key : m.keySet()) {
					List<FormDataBodyPart> parts = form.getFields(key);
					for (FormDataBodyPart part : parts) {
						if (MediaTypes.typeEqual(MediaType.TEXT_PLAIN_TYPE, part.getMediaType())) {
							map.add(key, part.getValue());
						}
					}
				}

				ByteArrayInputStream bais = (ByteArrayInputStream) in;
				bais.reset();

				// TODO: write code.
				// map.getFirst("authToken");

			} else {
				// Media none
				if (!r.bufferEntity()) {
					// warn("Unsupported buffer entity.");
				}

				Form f = r.readEntity(Form.class);
				MultivaluedMap<String, String> map = f.asMap();

				// TODO: write code.
				// map.getFirst("authToken");

				r.getEntityStream().reset(); // 次のフィルター使用する場合、リセットされていない為

			}
		}

	}

}
