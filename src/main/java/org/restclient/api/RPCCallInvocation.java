package org.restclient.api;

public abstract class RPCCallInvocation<I,O> {

	private final EndpointProvider<I> endpointProvider;
	private final Class<O> returnType;
	
	protected RPCCallInvocation(EndpointProvider<I> endpointProvider, Class<O> returnType) {
		this.endpointProvider = endpointProvider;
		this.returnType = returnType;
	}

	protected EndpointProvider<I> endpointProvider() {
		return endpointProvider;
	}

	protected Class<O> returnType() {
		return returnType;
	}
	
	protected abstract O invoke(I input);
	
	protected String endpointUrl(I input){
		return this.endpointProvider.resolveEndpointUrl(input);
	}
}
