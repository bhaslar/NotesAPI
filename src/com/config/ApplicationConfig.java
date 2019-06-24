package com.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.controller.IndexController;
import com.controller.NotesController;

/**
 * ApplicationConfig.java
 * Jersey application configuration that registers apis for the program
 * @author Ben Haslar
 * 
 */
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		register(NotesController.class);
		register(IndexController.class);
	}
}
