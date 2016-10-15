package com.cetc32.spring.jersey.app;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JaxRsApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public JaxRsApplication() {
		this.packages("com.cetc32.spring.jersey.resources");

		// register features
		register(JacksonFeature.class);

		register(MultiPartFeature.class);
	}

}
