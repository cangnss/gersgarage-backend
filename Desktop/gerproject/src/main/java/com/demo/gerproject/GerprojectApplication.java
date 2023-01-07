package com.demo.gerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.demo" })
public class GerprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerprojectApplication.class, args);
	}

}
