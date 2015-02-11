package org.restclient.api;

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
}
