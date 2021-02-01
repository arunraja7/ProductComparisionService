package com.org.relayr.productcomparison.dto;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.org.relayr.productcomparison.collections.Products;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductsDto is the Data Transfer Object used to process the Product DB Data in and out
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class ProductsDto {

	@JsonProperty("product_id")
	private long productID;

	@JsonProperty("product_name")
	private String productName;

	@JsonProperty("category")
	private String category;

	@JsonProperty("price")
	private long price;

	@JsonProperty("buy_type")
	private String buyType;
	
	@JsonProperty("store_name")
	private String storeName;

	@JsonProperty("location_url")
	private String locationUrl;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("sys_tm_stmp")
	private Date sysTmStmp;

	/**
	 * toProductsDto is builder to convert Products from DB to ProductsDto
	 * 
	 * @param Products
	 * @return ProductsDto
	 */
	public static ProductsDto toProductsDto(Products products) {
		return new ProductsDto().setProductID(products.getProductID())
				.setProductName(products.getProductName())
				.setCategory(products.getCategory())
				.setBuyType(products.getBuyType())
				.setStoreName(products.getStoreName())
				.setLocationUrl(products.getLocationUrl())
				.setImageUrl(products.getImageUrl())
				.setPrice(products.getPrice())
				.setSysTmStmp(products.getSysTmStmp());
	}

	/**
	 * toProducts is builder to convert ProductsDto to Products for DB
	 * 
	 * @param ProductsDto
	 * @return Products
	 */
	public static Products toProducts(ProductsDto productsDto) {
		return new Products().setProductID(productsDto.getProductID())
				.setProductName(productsDto.getProductName())
				.setCategory(productsDto.getCategory())
				.setBuyType(productsDto.getBuyType())
				.setStoreName(productsDto.getStoreName())
				.setLocationUrl(productsDto.getLocationUrl())
				.setImageUrl(productsDto.getImageUrl())
				.setPrice(productsDto.getPrice())
				.setSysTmStmp(Objects.nonNull(productsDto.getSysTmStmp()) ? productsDto.getSysTmStmp() : new Date());
	}

}
