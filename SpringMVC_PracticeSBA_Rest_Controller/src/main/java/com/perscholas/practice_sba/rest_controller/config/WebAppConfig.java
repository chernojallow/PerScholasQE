package com.perscholas.practice_sba.rest_controller.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.perscholas.practice_sba.rest_controller.models.Vehicle;

@Configuration
@ComponentScan("com.perscholas.practice_sba.rest_controller")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	Map<Integer, Vehicle> vehicleMap() {
		Map<Integer, Vehicle> sMap = new HashMap<>();
		Vehicle vehicle;

		vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setMake("Toyota");
		vehicle.setModel("Avalon");
		vehicle.setColors(new ArrayList<String>(Arrays.asList("Green", "Blue", "Red")));
		sMap.put(vehicle.getVehicleId(), vehicle);

		vehicle = new Vehicle();
		vehicle.setVehicleId(2);
		vehicle.setMake("Toyota");
		vehicle.setModel("Corolla");
		vehicle.setColors(new ArrayList<String>(Arrays.asList("Purple", "White", "Black")));
		sMap.put(vehicle.getVehicleId(), vehicle);

		vehicle = new Vehicle();
		vehicle.setVehicleId(3);
		vehicle.setMake("Tesla");
		vehicle.setModel("Model X");
		vehicle.setColors(new ArrayList<String>(Arrays.asList("Yellow", "Red", "Gray")));
		sMap.put(vehicle.getVehicleId(), vehicle);
		
		return sMap;
	}
}
