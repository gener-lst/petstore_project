package com.example.petstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy

public class PetApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}
	// springboot를 실행하기 위한 application
}