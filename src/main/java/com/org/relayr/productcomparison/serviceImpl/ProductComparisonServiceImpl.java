package com.org.relayr.productcomparison.serviceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.org.relayr.productcomparison.dao.ProductComparisonDao;
import com.org.relayr.productcomparison.dto.ProductsDto;
import com.org.relayr.productcomparison.entities.AIServiceResponse;
import com.org.relayr.productcomparison.entities.ProductResponse;
import com.org.relayr.productcomparison.service.ProductComparisonService;


/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonServiceImpl holds the implementation for Business logics of Product Comparison services
 */
@Service
public class ProductComparisonServiceImpl implements ProductComparisonService {

	@Autowired
	private ProductComparisonDao productComparisonDao;

	@Autowired
	RestTemplate restTemplate;

	@Value("${ai.service.url:'https://localhost:8090/callAI'}")
	private String aiServiceUrl;

	@Override
	public ResponseEntity<ProductResponse> searchData(ProductsDto productsDto) {
		ProductResponse productResponse = new ProductResponse();
		if (StringUtils.isEmpty(productsDto.getCategory()) && StringUtils.isEmpty(productsDto.getProductName())) {
			productResponse.setMessage("No Search Parameter Found");
			productResponse.setStatusCode(400);
		} else {
			List<ProductsDto> productsDtoList = productComparisonDao.searchData(productsDto);
			if (Objects.isNull(productsDtoList) || productsDtoList.isEmpty()) {
				productResponse.setMessage("No Data Found");
				productResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
			} else {
				if (StringUtils.isNotBlank(aiServiceUrl)) {
					Map<String, String> requestParamMap = new HashMap<String, String>();
					if (StringUtils.isNotBlank(productsDto.getProductName())) {
						requestParamMap.put("product_name", productsDto.getProductName());
					}
					if (StringUtils.isNotBlank(productsDto.getCategory())) {
						requestParamMap.put("category", productsDto.getCategory());
					}
					try {
						HttpHeaders headers = new HttpHeaders();
						headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
						headers.setContentType(MediaType.APPLICATION_JSON);
						HttpEntity<Map<String, String>> httpEntity = new HttpEntity<Map<String, String>>(
								requestParamMap, headers);
						ResponseEntity<AIServiceResponse> responseEntity = restTemplate.exchange(aiServiceUrl,
								HttpMethod.POST, httpEntity, AIServiceResponse.class);
						if (Objects.nonNull(responseEntity) && Objects.nonNull(responseEntity.getBody())) {
							Map<String, Integer> aiServiceMap = responseEntity.getBody().getAiServiceMap();
							if (Objects.nonNull(aiServiceMap) && !aiServiceMap.isEmpty()) {
								Collections.sort(productsDtoList, (productOne, ProductTwo) -> {
									int priceDiff = productOne.getPrice() == ProductTwo.getPrice() ? 0
											: (productOne.getPrice() > ProductTwo.getPrice()) ? 1 : -1;
									if (priceDiff != 0) {
										return priceDiff;
									} else {
										if (aiServiceMap.containsKey(productOne.getStoreName())
												&& aiServiceMap.containsKey(ProductTwo.getStoreName())) {
											return aiServiceMap.get(productOne.getStoreName()) == aiServiceMap
													.get(ProductTwo.getStoreName())
															? 0
															: (aiServiceMap
																	.get(productOne.getStoreName()) > aiServiceMap
																			.get(ProductTwo.getStoreName())) ? -1 : 1;
										} else {
											return priceDiff;
										}
									}
								});
							}
						}
					} catch (Exception exception) {
						System.out.println(exception.getMessage());
					}

				}
				productResponse.setMessage("Successfully fetched " + productsDtoList.size() + " records");
				productResponse.setStatusCode(HttpStatus.OK.value());
				productResponse.setProductList(productsDtoList);
			}
		}
		return ResponseEntity.status(productResponse.getStatusCode()).body(productResponse);
	}

	@Override
	public ResponseEntity<ProductResponse> createProduct(ProductsDto productsDto) {
		ProductResponse productResponse = new ProductResponse();
		try {
			long insertCount = productComparisonDao.createProduct(productsDto);
			return updateResponseCode(insertCount, productResponse);
		} catch (Exception exception) {
			productResponse.setMessage(exception.getMessage());
			productResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productResponse);
		}
	}

	@Override
	public ResponseEntity<ProductResponse> createProducts(List<ProductsDto> productsDtoList) {
		ProductResponse productResponse = new ProductResponse();
		try {
			long insertCount = productComparisonDao.createProducts(productsDtoList);
			return updateResponseCode(insertCount, productResponse);
		} catch (Exception exception) {
			productResponse.setMessage(exception.getMessage());
			productResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productResponse);
		}
	}

	/**
	 * updateResponseCode is used to update the response code based on the DB Operation result
	 * 
	 * @param insertCount
	 * @param productResponse
	 * @return ResponseEntity<ProductResponse>
	 */
	private ResponseEntity<ProductResponse> updateResponseCode(long insertCount, ProductResponse productResponse) {
		productResponse.setMessage("Number of Records Created " + insertCount);
		productResponse.setStatusCode(insertCount > 0 ? HttpStatus.CREATED.value() : HttpStatus.NOT_MODIFIED.value());
		return ResponseEntity.status(productResponse.getStatusCode()).body(productResponse);
	}
}
