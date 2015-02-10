package org.restcaller.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 * Annotation to indicate that an interface type
 * defines specifications for making rest calls.
 * 
 * @author Bappaditya.Mallick
 *
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface RestCall {
	HttpMethod httpMethod() default HttpMethod.GET;
	String contentType() default MediaType.APPLICATION_JSON_VALUE;
	String accepts() default MediaType.APPLICATION_JSON_VALUE;
	
}
