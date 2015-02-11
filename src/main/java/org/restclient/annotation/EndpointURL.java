package org.restclient.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines the endpoint url to hit to make
 * the rest call.
 * 
 * @author Bappaditya.Mallick
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface EndpointURL {
	/**
	 * Endpoint URL to hit. 
	 * 
	 * @return
	 */
	String value();
}
