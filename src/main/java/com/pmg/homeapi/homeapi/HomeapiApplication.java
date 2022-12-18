package com.pmg.homeapi.homeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HomeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeapiApplication.class, args);
	}

}
