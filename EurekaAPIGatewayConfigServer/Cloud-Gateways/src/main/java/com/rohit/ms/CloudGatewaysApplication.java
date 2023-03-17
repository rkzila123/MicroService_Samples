package com.rohit.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGatewaysApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewaysApplication.class, args);
	}

}
