package com.perscholas.hibernate_validation_repository.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.perscholas.hibernate_validation_repository")
@PropertySource("classpath:/application.properties")
public class RootAppConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource mariaDbDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("mariadb.driver"));
		ds.setUrl(env.getRequiredProperty("mariadb.url"));
		return ds;
	}
	@Bean("mariaDbJdbcTemplate")
	public NamedParameterJdbcTemplate getMariaDbJdbcTemplate() {
		return new NamedParameterJdbcTemplate(mariaDbDataSource());
	}
}