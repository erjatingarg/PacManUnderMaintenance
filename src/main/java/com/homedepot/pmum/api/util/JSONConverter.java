/*
 * This program is proprietary to The Home Depot and is not to be
 * reproduced, used, or disclosed without permission of:
 *
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 *
 * File Name: JSONConverter.java
 * Application: Store Traits Services
 * Owner:  The Home Depot Inc
 */
package com.homedepot.pmum.api.util;

import com.google.gson.Gson;

/**
 * The utility class wraps the implementation of Google's Gson API and provides
 * the utility of 'from' and 'to' conversions of JSON <-> Object.
 * 
 * @param <T>
 *            the
 * @author EHN9A5M
 */
public class JSONConverter {

	/** The gson. */
	private static Gson gson = new Gson();

	/**
	 * Generates a json string from an object.
	 * 
	 * @param obj
	 *            Any pojo object
	 * @return a JSON string
	 */
	
	/*
	 * As per sonarQube recommendation this constructor forces the user not to instantiate the class
	 * directly and instead use the static methods by using the class name
	 */	
	private JSONConverter(){
		
	}
	
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 * Creates the object.
	 * 
	 * @param jsonString
	 *            the json string
	 * @param t
	 *            the t
	 * @return the t
	 */
	public static  <T> T createObject(String jsonString, Class<T> t) {

		return gson.fromJson(jsonString, t);

	}

	
}