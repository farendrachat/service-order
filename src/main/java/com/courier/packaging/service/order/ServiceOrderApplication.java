package com.courier.packaging.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.courier.packaging.*" })

public class ServiceOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOrderApplication.class, args);
	}

}
