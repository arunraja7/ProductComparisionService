package com.org.relayr.productcomparison.dao;

import java.util.List;

import com.org.relayr.productcomparison.dto.ProductsDto;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonDao is the DAO layer for Accessing the PRODUCTS data
 */
public interface ProductComparisonDao {

	/**
	 * searchData is used to search the product information using Product Name and Category
	 * 
	 * @param ProductsDto
	 * @return List<ProductsDto>
	 */
	public List<ProductsDto> searchData(ProductsDto productsDto);

	/**
	 * createProduct is used to insert single Product data into DB
	 * 
	 * @param ProductsDto
	 * @return long
	 */
	public long createProduct(ProductsDto productsDto);

	/**
	 * createProduct is used to insert Multiple Product data into DB
	 * 
	 * @param List<ProductsDto>
	 * @return long
	 */
	public long createProducts(List<ProductsDto> productsDto);
}
