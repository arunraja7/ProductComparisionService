package com.org.relayr.productcomparison.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.org.relayr.productcomparison.dao.ProductComparisonDao;
import com.org.relayr.productcomparison.daoImpl.ProductComparisonMongoDaoImpl;


/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonConfig is used to intiate the beans
 */
@EnableAutoConfiguration
@Configuration
public class ProductComparisonConfig {

	/**
	 * getProductComparisonMongoDao creates bean for MongoDB Implementation layer
	 * 
	 * @return ProductComparisonMongoDaoImpl
	 */
	@Bean
	public ProductComparisonDao getProductComparisonMongoDao() {
		return new ProductComparisonMongoDaoImpl();
	}

	/**
	 * getRestTemplate creates instance for RestTemplate to call Third party API's
	 * 
	 * @return RestTemplate
	 */
	@Bean
	@Autowired
	RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
}
