package com.swashtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@PropertySource("file:./etc/config/application.properties")
public class Application {

	public static void main(String[] args) {
		System.err.print("Starting SpringBoot");
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ConfigurableEnvironment env = context.getEnvironment();
		System.err.println("MongoDB URL -------> : "+env.getProperty("spring.data.mongodb.uri"));
	}
	
}
