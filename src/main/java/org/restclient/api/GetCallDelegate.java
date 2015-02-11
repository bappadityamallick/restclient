package org.restclient.api;

import org.springframework.web.client.RestTemplate;

class GetCallDelegate<I,O> extends RestCallDelegate<I, O>{

	protected GetCallDelegate(Class<O> responseType,
			String contentType, String accepts) {
		super(responseType,contentType, accepts);
	}

	@Override
	protected O invoke(I input, RestTemplate restTemplate, String url) {
		return restTemplate.getForObject(url, responseType, headers);
	}
	
}