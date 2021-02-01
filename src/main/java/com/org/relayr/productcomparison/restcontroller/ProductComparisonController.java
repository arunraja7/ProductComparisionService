package com.org.relayr.productcomparison.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.relayr.productcomparison.dto.ProductsDto;
import com.org.relayr.productcomparison.entities.ProductResponse;
import com.org.relayr.productcomparison.service.ProductComparisonService;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonController is rest controller for handling all the API call's
 */
@RestController
public class ProductComparisonController {

	@Autowired
	ProductComparisonService productComparisonService;

	@PostMapping(value = "searchProducts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponse> searchProducts(@RequestBody ProductsDto productsDto) {
		return productComparisonService.searchData(productsDto);
	}

	@PostMapping(value = "createProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductsDto productsDto) {
		return productComparisonService.createProduct(productsDto);
	}

	@PostMapping(value = "createProducts", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductResponse> createProducts(@RequestBody List<ProductsDto> productsDto) {
		return productComparisonService.createProducts(productsDto);
	}

}
