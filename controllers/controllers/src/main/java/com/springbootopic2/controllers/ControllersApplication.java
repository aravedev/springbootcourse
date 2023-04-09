package com.springbootopic2.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class ControllersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllersApplication.class, args);
	}

}
