package org.restclient.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

abstract class RestCallDelegate<I,O>{
	protected final Map<String, String> headers = new HashMap<>();
	protected final Class<O> responseType;
	
	protected RestCallDelegate(Class<O> responseType, String contentType, String accepts){
		this.responseType = responseType;
		this.headers.put(HttpHeaders.CONTENT_TYPE, contentType);
		this.headers.put(HttpHeaders.ACCEPT, accepts);
	}
	
	protected abstract O invoke(I input, RestTemplate restTemplate, String url);
}