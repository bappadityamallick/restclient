package org.restcaller.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

public abstract class RPCInvocationHandler<RI extends RPCCallInvocation> implements InvocationHandler {

	private final Map<Method, RI> invocationCallRegistry;
	
	protected RPCInvocationHandler(Class targetType) {
		final Map<Method, RI> callDefinitions = parseCallDefinitions(targetType);
		this.invocationCallRegistry = callDefinitions!=null?Collections.unmodifiableMap(callDefinitions):Collections.EMPTY_MAP;	
		init();
	}

	protected void init(){
		
	}
	
	protected abstract Map<Method, RI> parseCallDefinitions(Class targetType);
	
	@Override
	public Object invoke(Object target, Method method, Object[] parameters)
			throws Throwable {
		final RI callInvocation = invocationCallRegistry.get(method);
		if(null!=callInvocation){
			//found a callInvocation.
			return callInvocation.invoke(resolveParameter(parameters));
		}else{
			throw new IllegalStateException("No RPC Call defined for method :"+method);
		}
	}

	private Object resolveParameter(Object[] parameters) {
		return (null == parameters || parameters.length==0)?null:parameters[0] ;
	}

}
