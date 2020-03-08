package com.example.assembly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoAssemblyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAssemblyApplication.class, args);
	}

}
