package com.esteben.carmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}

}
