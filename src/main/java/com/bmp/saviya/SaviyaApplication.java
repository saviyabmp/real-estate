package com.bmp.saviya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


//Excule the default autoconfig to enable the custom security config
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EntityScan
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.bmp.saviya"})
public class SaviyaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SaviyaApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(SaviyaApplication.class, args);
	}
}