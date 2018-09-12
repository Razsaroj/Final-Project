package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"Service", "Controller", "Model", "Config"})
public class DemoTestApplication {
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoTestApplication.class, args);
	}
}
