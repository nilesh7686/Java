package com.example.email_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailWebApiApplication.class, args);
		System.out.println("server started");
	}

}
