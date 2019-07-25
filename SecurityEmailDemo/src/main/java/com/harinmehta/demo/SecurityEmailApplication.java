package com.harinmehta.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SecurityEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityEmailApplication.class, args);
	}

}
