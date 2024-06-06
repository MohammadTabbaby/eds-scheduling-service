package com.example.schedulingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SchedulingService {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingService.class, args);
	}

}
