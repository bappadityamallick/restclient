package org.restcaller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class RestCallInvocation<I,O> extends RPCCallInvocation<I, O> {
	
	private final RestTemplate restTemplate;
	
	private final RestCallDelegate<I, O> callDelegate;
	
	

	protected RestCallInvocation(EndpointProvider<I> endpointProvider,
			Class<O> returnType, RestTemplate restTemplate,
			HttpMethod httpMethod, String contentType, String accepts) {
		super(endpointProvider, returnType);
		this.restTemplate = restTemplate;
		this.callDelegate = createCallDelegate(returnType,httpMethod,contentType,accepts);
	}

	@Override
	protected O invoke(I input) {
		return this.callDelegate.invoke(input, this.restTemplate, this.endpointUrl(input));
	}

	private RestCallDelegate<I, O> createCallDelegate(Class<O> responseType, HttpMethod httpMethod,
			String contentType, String accepts) {
		switch (httpMethod) {
		case GET:return new GetCallDelegate(responseType, contentType, accepts);

		default:throw new IllegalStateException("No Handler defined for httpMethod "+httpMethod);
		}
	}

	
	private abstract class RestCallDelegate<I,O>{
		protected final Map<String, String> headers = new HashMap<>();
		protected final Class<O> responseType;
		
		protected RestCallDelegate(Class<O> responseType, String contentType, String accepts){
			this.responseType = responseType;
			this.headers.put(HttpHeaders.CONTENT_TYPE, contentType);
			this.headers.put(HttpHeaders.ACCEPT, accepts);
		}
		
		protected abstract O invoke(I input, RestTemplate restTemplate, String url);
	}
	
	private class GetCallDelegate<I,O> extends RestCallDelegate<I, O>{

		protected GetCallDelegate(Class<O> responseType,
				String contentType, String accepts) {
			super(responseType,contentType, accepts);
		}

		@Override
		protected O invoke(I input, RestTemplate restTemplate, String url) {
			return restTemplate.getForObject(url, responseType, headers);
		}
		
	}
}
