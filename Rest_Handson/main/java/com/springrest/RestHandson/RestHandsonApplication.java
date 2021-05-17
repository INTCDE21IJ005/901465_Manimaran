package com.springrest.RestHandson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springrest")
public class RestHandsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestHandsonApplication.class, args);
	}

}
