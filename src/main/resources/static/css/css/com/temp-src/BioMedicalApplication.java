package com.labinsights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

 
@SpringBootApplication
@EnableAsync
public class BioMedicalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BioMedicalApplication.class, args);
	}

}
