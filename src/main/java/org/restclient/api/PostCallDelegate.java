package org.restclient.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

class PostCallDelegate<I, O> extends RestCallDelegate<I, O> {

	protected PostCallDelegate(Class<O> responseType, String contentType,
			String accepts) {
		super(responseType, contentType, accepts);
	}

	@Override
	protected O invoke(I input, RestTemplate restTemplate, String url) {
		final ResponseEntity<O> response = restTemplate.postForEntity(url,
				input, responseType, headers);
		final HttpStatus statusCode = response.getStatusCode();
		switch (statusCode) {
		case OK:
			return response.getBody();
		default:
			throw new HttpServerErrorException(statusCode);
		}
	}

}