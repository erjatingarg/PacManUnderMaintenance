package com.homedepot.pmum.api.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class CloudServiceLoader {
	
	private static final List<String> SERVICE_NODES = Arrays
			.asList(new String[] { "user-provided", "p-mysql", "p-redis" });

	
	/*
	 * As per sonarQube recommendation this constructor forces the user not to instantiate the class
	 * directly and instead use the static methods by using the class name
	 */	
	private CloudServiceLoader(){
		
	}

	@SuppressWarnings({ "unchecked" })
	public static Map<String, Object> getCredentials(String vcapServices, String serviceName) {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> services = null;
		Map<String, Object> credentialMap = null;
		String serviceValue = null;
		try {
			map = gson.fromJson(vcapServices, map.getClass());
			if (map != null) {
				for (String node : SERVICE_NODES) {
					if (map.containsKey(node)) {
						services = (List<Map<String, Object>>) map.get(node);
						if (services != null) {
							for (Map<String, Object> service : services) {
								if (service.containsKey("name")) {
									serviceValue = (String) service.get("name");
									if (serviceName.equals(serviceValue)) {
										if (service.containsKey("credentials")) {
											return (Map<String, Object>) service.get("credentials");
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new IllegalStateException("Error parsing VCAP Services", e);
		}
		return credentialMap;
	}
}