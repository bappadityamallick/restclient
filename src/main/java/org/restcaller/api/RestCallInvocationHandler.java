package org.restcaller.api;

import java.lang.reflect.Method;
import java.util.Map;

public class RestCallInvocationHandler extends RPCInvocationHandler<RestCallInvocation> {

	protected RestCallInvocationHandler(Class targetType) {
		super(targetType);
	}

	@Override
	protected Map<Method, RestCallInvocation> parseCallDefinitions(Class targetType) {
		return null;
	}

}
