package com.mirea.practice6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = { JacksonAutoConfiguration.class }) // Exclude the automatic configuration of JACKSON
public class Practice6Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice6Application.class, args);
	}

}
