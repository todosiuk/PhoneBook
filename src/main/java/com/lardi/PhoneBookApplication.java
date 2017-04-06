package com.lardi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class PhoneBookApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PhoneBookApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(PhoneBookApplication.class, args);
	}

}
