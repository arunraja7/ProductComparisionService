package com.org.relayr.productcomparison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonApplication is used to Start the Spring boot Application
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProductComparisonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductComparisonApplication.class, args);
	}

}
