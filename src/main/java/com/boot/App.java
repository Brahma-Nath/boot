package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.controller.BootController;

/**
 * Graph Spring Boot MicroService!
 *
 */
@Configuration
@ComponentScan(basePackageClasses = { BootController.class })
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {
		System.out.println("Eat with Satisfaction!");
		SpringApplication.run(App.class, args);
	}
}
