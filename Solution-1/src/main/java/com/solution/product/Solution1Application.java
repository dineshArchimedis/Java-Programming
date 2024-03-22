package com.solution.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Solution1Application {

	public static void main(String[] args) {
		SpringApplication.run(Solution1Application.class, args);
	}

}
