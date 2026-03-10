package com.example.Spring_MVC;

import org.springframework.boot.SpringApplication;

public class TestSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringMvcApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
