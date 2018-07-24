package com.chat;

import org.springframework.boot.CommandLineRunner;
/**
 * 
 * @author Hassen Ben Slima , Anis Hakim
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBrokerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBrokerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
