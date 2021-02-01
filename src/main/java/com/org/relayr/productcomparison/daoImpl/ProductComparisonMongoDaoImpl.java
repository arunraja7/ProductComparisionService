package com.org.relayr.productcomparison.daoImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.org.relayr.productcomparison.collections.Products;
import com.org.relayr.productcomparison.dao.ProductComparisonDao;
import com.org.relayr.productcomparison.dto.ProductsDto;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonMongoDaoImpl is the DAO implementation layer for Accessing MongoDB PRODUCTS Data
 */
public class ProductComparisonMongoDaoImpl implements ProductComparisonDao {

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<ProductsDto> searchData(ProductsDto productsDto) {
		Query productsQuery = new Query();
		if (StringUtils.isNotBlank(productsDto.getProductName())) {
			productsQuery.addCriteria(Criteria.where("PRODUCT_NAME").is(productsDto.getProductName()));
		}
		if (StringUtils.isNotBlank(productsDto.getCategory())) {
			productsQuery.addCriteria(Criteria.where("CATEGORY").is(productsDto.getCategory()));
		}
		productsQuery.with(Sort.by(Direction.DESC, "PRICE"));
		return mongoTemplate.find(productsQuery, Products.class).stream().map(ProductsDto::toProductsDto)
				.collect(Collectors.toList());
	}

	@Override
	public long createProduct(ProductsDto productsDto) {
		if ((productsDto.getProductID() > 0) && (productsDto.getPrice() > 0)
				&& StringUtils.isNotBlank(productsDto.getBuyType()) && StringUtils.isNotBlank(productsDto.getCategory())
				&& StringUtils.isNotBlank(productsDto.getLocationUrl())
				&& StringUtils.isNotBlank(productsDto.getStoreName())
				&& StringUtils.isNotBlank(productsDto.getProductName())) {
			return StringUtils.isNotBlank(mongoTemplate.insert(ProductsDto.toProducts(productsDto)).getId()) ? 1 : 0;
		}
		return 0;
	}

	@Override
	public long createProducts(List<ProductsDto> productsDtoList) {
		List<Products> productsList = productsDtoList.stream().filter(product -> (product.getProductID() > 0)
				&& (product.getPrice() > 0) && StringUtils.isNotBlank(product.getBuyType())
				&& StringUtils.isNotBlank(product.getCategory()) && StringUtils.isNotBlank(product.getLocationUrl())
				&& StringUtils.isNotBlank(product.getStoreName()) && StringUtils.isNotBlank(product.getProductName()))
				.map(ProductsDto::toProducts).collect(Collectors.toList());
		return mongoTemplate.insertAll(productsList).size();
	}
}
