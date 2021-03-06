/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.vkontakte.api.impl;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * Generic class for template testing.
 * @author vkolodrevskiy
 */
public class AbstractVKontakteApiTest {
	protected VKontakteTemplate vkontakte;
	protected VKontakteTemplate unauthorizedVKontakte;
	//
	protected MockRestServiceServer mockServer;
	protected MockRestServiceServer unauthorizedMockServer;
	protected HttpHeaders responseHeaders;

	@Before
	public void setup() {
		responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		//
		vkontakte = new VKontakteTemplate("ACCESS_TOKEN", "CLIENT_SECRET");
		mockServer = MockRestServiceServer.createServer(vkontakte.getRestTemplate());
		// unauthorizedVK can be used to access vk api public methods.
		unauthorizedVKontakte = new VKontakteTemplate();
		unauthorizedMockServer = MockRestServiceServer.createServer(unauthorizedVKontakte.getRestTemplate());
	}

	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}
}
