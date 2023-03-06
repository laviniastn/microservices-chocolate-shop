package com.microservices.chocolateshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ChocolateshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChocolateshopApplication.class, args);
	}

}
