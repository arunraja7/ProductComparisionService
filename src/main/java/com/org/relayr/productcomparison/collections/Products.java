package com.org.relayr.productcomparison.collections;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * Products is the Structure of PRODUCTS Collection in MongoDB
 */
@Data
@Accessors(chain = true)
@Document(collection = "PRODUCTS")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Field("_id")
	private String id;

	@Field("PRODUCT_ID")
	private long productID;

	@Field("PRODUCT_NAME")
	private String productName;

	@Field("CATEGORY")
	private String category;

	@Field("PRICE")
	private long price;

	@Field("BUY_TYPE")
	private String buyType;

	@Field("STORE_NAME")
	private String storeName;
	
	@Field("LOCATION_URL")
	private String locationUrl;

	@Field("IMAGE_URL")
	private String imageUrl;

	@Field("SYS_TM_STMP")
	private Date sysTmStmp;
	
	

}
