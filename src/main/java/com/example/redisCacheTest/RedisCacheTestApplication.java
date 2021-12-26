package com.example.redisCacheTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example.redisCacheTest.*")
public class RedisCacheTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheTestApplication.class, args);
	}

}
