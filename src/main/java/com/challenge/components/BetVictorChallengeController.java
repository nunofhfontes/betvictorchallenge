package com.challenge.components;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.challenge")
@EntityScan(basePackages = {"com.challenge.domain"} )
@EnableJpaRepositories(basePackages = {"com.challenge.repository"} )
public class BetVictorChallengeController {
	
	public static void main(String[] args) {
		SpringApplication.run(BetVictorChallengeController.class, args);
	}
	
}



















