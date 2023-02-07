package com.rohit.ms.ps.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServicesApplication.class, args);
	}

}
