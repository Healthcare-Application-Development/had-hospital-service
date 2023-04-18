package com.example.hadhospitalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HadHospitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HadHospitalServiceApplication.class, args);
	}

}
