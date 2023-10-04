package com.mirea.practice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = { JacksonAutoConfiguration.class }) // Exclude the automatic configuration of JACKSON
public class Practice5Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice5Application.class, args);
	}

}
