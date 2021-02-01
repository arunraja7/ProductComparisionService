package com.org.relayr.productcomparison.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.org.relayr.productcomparison.dto.ProductsDto;

import lombok.Data;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductResponse is used to hold Response Data to search API Output
 */
@Data
@JsonPropertyOrder({"statusCode","message","productList"})
@JsonInclude(value = Include.NON_NULL)
public class ProductResponse {

	private int statusCode;
	private String message;
	private List<ProductsDto> productList;

}
