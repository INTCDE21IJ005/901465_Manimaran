package com.cognizant.springlearn;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages="com")
@SpringBootApplication
public class SpringLearnApplication {	
	public static void main(String[] args){
		SpringApplication.run(SpringLearnApplication.class, args);	
	}
}
