package com.esteben.gatewaymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayManagementApplication.class, args);
	}

}
