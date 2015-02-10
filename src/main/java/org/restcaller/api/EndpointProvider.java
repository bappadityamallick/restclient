package org.restcaller.api;

/**
 * Provides the url for endpoint to invoke at runtime.
 * 
 * @author Bappaditya.Mallick
 *
 */
public interface EndpointProvider<T> {
	String resolveEndpointUrl(T payload);
}
