package com.homedepot.pmum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PacManUnderMaintenanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PacManUnderMaintenanceApplication.class, args);
	}
}
