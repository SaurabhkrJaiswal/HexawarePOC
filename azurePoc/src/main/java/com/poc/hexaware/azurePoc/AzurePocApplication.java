package com.poc.hexaware.azurePoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AzurePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzurePocApplication.class, args);
	}

}
