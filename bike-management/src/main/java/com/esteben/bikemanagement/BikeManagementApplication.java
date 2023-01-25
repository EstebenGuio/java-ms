package com.esteben.bikemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BikeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeManagementApplication.class, args);
	}

}
