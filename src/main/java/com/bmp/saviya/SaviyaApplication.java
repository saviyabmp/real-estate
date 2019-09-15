package com.bmp.saviya.realestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.bmp.saviya.realestate.model"})
@EnableJpaRepositories(basePackages = {"com.bmp.saviya.realestate.repository"})
public class SaviyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaviyaApplication.class, args);
	}
}