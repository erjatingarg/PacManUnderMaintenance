package com.homedepot.pmum.api.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

public class LogLevel {
	
	/*
	 * As per sonarQube recommendation this constructor forces the user not to instantiate the class
	 * directly and instead use the static methods by using the class name
	 */	
	private LogLevel(){
		
	}

	public static void changeLogLevel(Level level){
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
		ctx.updateLoggers();
	}
}
