package org.restcaller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.restcaller.api.EndpointProvider;

/**
 * Provides information of the bean/class to be used for
 * dymanic endpoint url resolution. Defines the name of bean
 * or type which would be used to lookup endpointURL at runtime.
 * 
 * If both beanName or typeName is provided, beanName would
 * be used.
 * 
 * @author Bappaditya.Mallick
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface EndpointProviderSpec {
	/**
	 * Name of the bean which would be 
	 * used to lookup endpointURL at runtime.
	 * @return
	 */
	String value();
	/**
	 * The class type whose default instance would be 
	 * used to lookup endpointURL at runtime.
	 * @return
	 */
	Class<? extends EndpointProvider> type();
}
