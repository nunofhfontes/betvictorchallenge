package com.traderfactory.components;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.traderfactory")
@EntityScan(basePackages = {"com.traderfactory.domain"} )
@EnableJpaRepositories(basePackages = {"com.traderfactory.repository"} )
public class TraderFactoryController {
	
	public static void main(String[] args) {
		SpringApplication.run(TraderFactoryController.class, args);
	}
	
}



















