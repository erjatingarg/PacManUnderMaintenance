package com.homedepot.pmum.api.config;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceCache {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceCache.class);

	private static Map<String, DataSource> dataSourceMap = new LinkedHashMap<String, DataSource>();
	private static String VCAP_SERVICES = getVCapServices();
	// [@Value("${databaseconfig.filename}")]
	// [private static String connectionInfoFile="testvcapservices.dev";]
	
	
	/*
	 * As per sonarQube recommendation this constructor forces the user not to instantiate the class
	 * directly and instead use the static methods by using the class name.
	 * In this class all the methods are static.
	 */	
	private DataSourceCache(){
		
	}
	public static DataSource getDataSource(String serviceName) {
		DataSource ds = null;
		try {
			if (dataSourceMap.containsKey(serviceName)) {
				ds = dataSourceMap.get(serviceName);
			} else {
				if (VCAP_SERVICES == null || VCAP_SERVICES.isEmpty()) {
					VCAP_SERVICES = getVCapServices();
				}
				String info=serviceName + "\n\n loading vcap " + VCAP_SERVICES;
				LOGGER.debug(info);
				ds = createDataSource(VCAP_SERVICES, serviceName);
			}
		} catch (RuntimeException exp) {
			LOGGER.error(exp.getMessage(), exp);
		}
		return ds;
	}

	private static synchronized DataSource createDataSource(String vcapServices, String serviceName) {
		if (dataSourceMap.containsKey(serviceName)) {
			return dataSourceMap.get(serviceName);
		}
		DataSource dataSource = DataSourceLoader.load(vcapServices, serviceName);
		dataSourceMap.put(serviceName, dataSource);
		String info=serviceName + "Data Source info>>>>>>" + dataSource.toString();
		LOGGER.debug(info);
		return dataSource;
	}

	private static String getVCapServices() {
		String vcapServices = System.getenv("VCAP_SERVICES");

		if (vcapServices == null && System.getenv("VCAP_APPLICATION") == null) {
			vcapServices = getVcapServicesForH2Database();
		}

		return vcapServices;
	}

	private static String getVcapServicesForH2Database() {
		ClassLoader classLoader = DataSourceCache.class.getClassLoader();
		File file = new File(classLoader.getResource("vcapservices.dev").getFile());
		StringBuilder vcapServices = new StringBuilder();
		try(Scanner sc = new Scanner(file)) {
			
			while (sc.hasNextLine()) {
				vcapServices.append(sc.nextLine());
			}
		} catch (IOException e) {
			LOGGER.error("Error processing vcapservices.dev:" + e.getMessage(), e);
		} 
		return vcapServices.toString();
	}
}
