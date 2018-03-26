package com.AppDirect.jBilling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JBillingApplication.class, args);
	}
}
