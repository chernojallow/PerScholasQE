package com.perscholas.hibernate_validation_dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.perscholas.hibernate_validation_dao.dao.DatabaseConnection;


@Configuration
@ComponentScan("com.perscholas.hibernate_validation_dao")
public class RootAppConfig {
	@Bean
	public DatabaseConnection getDatabaseConnection() {
		return new DatabaseConnection();
	}
}