package com.org.relayr.productcomparison.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.relayr.productcomparison.dto.ProductsDto;
import com.org.relayr.productcomparison.entities.ProductResponse;

/**
 * @Created by Arun Raja Since 2/1/2021
 * 
 * ProductComparisonService holds the Business logic for Product Comparison Service
 */
public interface ProductComparisonService {

	/**
	 * searchData is used to search the product information using Product Name,
	 * Category and AI Review Service
	 * 
	 * @param ProductsDto
	 * @return ResponseEntity<ProductResponse>
	 */
	public ResponseEntity<ProductResponse> searchData(ProductsDto productsDto);

	/**
	 * createProduct is used to insert single Product data into DB
	 * 
	 * @param ProductsDto
	 * @return ResponseEntity<ProductResponse>
	 */
	public ResponseEntity<ProductResponse> createProduct(ProductsDto productsDto);

	/**
	 * createProduct is used to insert Multiple Product data into DB
	 * 
	 * @param List<ProductsDto>
	 * @return ResponseEntity<ProductResponse>
	 */
	public ResponseEntity<ProductResponse> createProducts(List<ProductsDto> productsDto);

}
