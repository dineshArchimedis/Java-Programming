package com.dinesh.firstspringbootapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	
	@Value("${welcome.message}")
	private String message;
	
	@GetMapping("/")
	public String HelloWorld() {
		return message;
	}
}
