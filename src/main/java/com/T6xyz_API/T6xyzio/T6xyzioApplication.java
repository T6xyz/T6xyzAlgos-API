package com.T6xyz_API.T6xyzio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class T6xyzioApplication {

	public static void main(String[] args) {
		SpringApplication.run(T6xyzioApplication.class, args);
	}

}
