package com.org.relayr.productcomparison.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.org.relayr.productcomparison.dao.ProductComparisonDao;
import com.org.relayr.productcomparison.dto.ProductsDto;
import com.org.relayr.productcomparison.entities.AIServiceResponse;
import com.org.relayr.productcomparison.entities.ProductResponse;
import com.org.relayr.productcomparison.serviceImpl.ProductComparisonServiceImpl;


/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * ProductComparisonServiceImplTest is used to test all the corner test cases of the Business
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductComparisonServiceImplTest {

	@InjectMocks
	ProductComparisonServiceImpl productComparisonServiceImpl;

	@Mock
	private ProductComparisonDao productComparisonDao;

	@Mock
	RestTemplate restTemplate;

	List<ProductsDto> productsDtoList;

	ResponseEntity<ProductResponse> productsResponse;

	ProductsDto productsInputDto;

	/**
	 * init method is used for Bean initialization and Data Preparation for test cases
	 * 
	 */
	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
		productsDtoList = new ArrayList<>();

		ProductsDto productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(2000);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce 1");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(1800);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce 2");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(2100);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce 3");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(2500);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce 4");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);
		
		productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(2500);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce 5");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);
		
		productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(2100);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce 6");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("STORE");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://www.google.com/maps/place/Fan+Store/@xx.xxxxxx,xx.xxxxxx");
		productsDto.setPrice(2000);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("Fan Store 1");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("STORE");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://www.google.com/maps/place/Fan+Store/@xx.xxxxxx,xx.xxxxxx");
		productsDto.setPrice(1900);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("Fan Store 2");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("STORE");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://www.google.com/maps/place/Fan+Store/@xx.xxxxxx,xx.xxxxxx");
		productsDto.setPrice(2100);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("Fan Store 3");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("STORE");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://www.google.com/maps/place/Fan+Store/@xx.xxxxxx,xx.xxxxxx");
		productsDto.setPrice(2400);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("Fan Store 4");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);
		
		productsDto = new ProductsDto();
		productsDto.setBuyType("STORE");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://www.google.com/maps/place/Fan+Store/@xx.xxxxxx,xx.xxxxxx");
		productsDto.setPrice(2400);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("Fan Store 4");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);
	}

	/**
	 * searchDataProductNameCategoryTest method is used for testing the Search Operation using both 
	 * product Name and Category as a parameter without using AI service
	 * 
	 */
	@Test
	public void searchDataProductNameCategoryTest() {
		productsInputDto = new ProductsDto();
		productsInputDto.setProductName("voltas fan");
		productsInputDto.setCategory("fan");
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(productsDtoList);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);

	}

	/**
	 * searchDataBadRequestTest method is used for testing the negative scenario of validating the data input in Search API
	 * 
	 */
	@Test
	public void searchDataBadRequestTest() {

		productsInputDto = new ProductsDto();
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList(), null);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.BAD_REQUEST);

		productsInputDto = new ProductsDto();
		productsInputDto.setProductName("No Data");
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(new ArrayList<>());
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList(), null);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.NO_CONTENT);
	}

	/**
	 * searchDataNoContentTest method is used for testing No data exists scenario
	 * 
	 */
	@Test
	public void searchDataNoContentTest() {

		productsInputDto = new ProductsDto();
		productsInputDto.setProductName("No Data");
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(new ArrayList<>());
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList(), null);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.NO_CONTENT);
		
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(null);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList(), null);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.NO_CONTENT);
	}

	/**
	 * searchWithAIAPITest method is used for testing the search service along with AI Review API
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void searchWithAIAPITest() {
		String aiServiceUrl = "https://localhost:8090/callAI";
		ReflectionTestUtils.setField(productComparisonServiceImpl, "aiServiceUrl", aiServiceUrl);
		productsInputDto = new ProductsDto();
		productsInputDto.setProductName("voltas fan");
		Map<String, String> requestParamMap = new HashMap<String, String>();
		requestParamMap.put("product_name", productsInputDto.getProductName());
		Map<String, Integer> aiResponseMap = new HashMap<String, Integer>();
		aiResponseMap.put("Fan Store 1", 5);
		aiResponseMap.put("Fan Store 2", 3);
		aiResponseMap.put("Fan Store 3", 4);
		aiResponseMap.put("Fan Store 4", 5);
		aiResponseMap.put("E Commerce 1", 5);
		aiResponseMap.put("E Commerce 2", 2);
		aiResponseMap.put("E Commerce 3", 5);
		aiResponseMap.put("E Commerce 4", 4);
		AIServiceResponse aiServiceResponse = new AIServiceResponse();
		aiServiceResponse.setAiServiceMap(aiResponseMap);
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(productsDtoList);
		ResponseEntity<AIServiceResponse> responseEntity = ResponseEntity.ok(aiServiceResponse);
		
		/**
		 * Data fetched scenario from AI Review Api with Product Name as parameter
		 * 
		 */
		when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<AIServiceResponse>>any())).thenReturn(responseEntity);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getBody().getProductList().get(0).getPrice(), 1800);
		assertEquals(productsResponse.getBody().getProductList().get(0).getStoreName(), "E Commerce 2");
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		
		/**
		 * Data fetched scenario from AI Review Api with Category as parameter
		 * 
		 */
		productsInputDto = new ProductsDto();
		productsInputDto.setCategory("fan");
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(productsDtoList);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		
		/**
		 * Null fetch scenario from AI Review Api Endpoint
		 * 
		 */
		when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<AIServiceResponse>>any())).thenReturn(null);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getBody().getProductList().get(0).getPrice(), 1800);
		assertEquals(productsResponse.getBody().getProductList().get(0).getStoreName(), "E Commerce 2");
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		
		/**
		 * Data not fetched scenario from AI Review Api Endpoint
		 * 
		 */
		when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<AIServiceResponse>>any())).thenReturn(ResponseEntity.ok(null));
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getBody().getProductList().get(0).getPrice(), 1800);
		assertEquals(productsResponse.getBody().getProductList().get(0).getStoreName(), "E Commerce 2");
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		

		/**
		 * Exception thrown scenario from AI Review Api
		 * 
		 */
		when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<AIServiceResponse>>any())).thenThrow(new NullPointerException());
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getBody().getProductList().get(0).getPrice(), 1800);
		assertEquals(productsResponse.getBody().getProductList().get(0).getStoreName(), "E Commerce 2");
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		
		/**
		 * Empty Data fetched from AI Review Api service
		 * 
		 */
		aiServiceResponse = new AIServiceResponse();
		aiServiceResponse.setAiServiceMap(new HashMap<>());
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(productsDtoList);
		responseEntity = ResponseEntity.ok(aiServiceResponse);
		when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<AIServiceResponse>>any())).thenReturn(responseEntity);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getBody().getProductList().get(0).getPrice(), 1800);
		assertEquals(productsResponse.getBody().getProductList().get(0).getStoreName(), "E Commerce 2");
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		
		
		/**
		 * Null Data fetched from AI Review Api service
		 * 
		 */
		aiServiceResponse = new AIServiceResponse();
		aiServiceResponse.setAiServiceMap(null);
		when(productComparisonDao.searchData(productsInputDto)).thenReturn(productsDtoList);
		responseEntity = ResponseEntity.ok(aiServiceResponse);
		when(restTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class), Matchers.<HttpEntity<?>>any(),
				Matchers.<Class<AIServiceResponse>>any())).thenReturn(responseEntity);
		productsResponse = productComparisonServiceImpl.searchData(productsInputDto);
		assertEquals(productsResponse.getBody().getProductList().size(), productsDtoList.size());
		assertEquals(productsResponse.getBody().getProductList().get(0).getPrice(), 1800);
		assertEquals(productsResponse.getBody().getProductList().get(0).getStoreName(), "E Commerce 2");
		assertEquals(productsResponse.getStatusCode(), HttpStatus.OK);
		
	}


	/**
	 * createProductTest is used to Test the Insert single record Business logic
	 * 
	 */
	@Test
	public void createProductTest() {
		ResponseEntity<ProductResponse> productsResponse;

		ProductsDto productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(5000);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce");
		productsDto.setSysTmStmp(new Date());

		/**
		 * Data not inserted condition
		 * 
		 */
		when(productComparisonDao.createProduct(productsDto)).thenReturn(0L);
		productsResponse = productComparisonServiceImpl.createProduct(productsDto);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.NOT_MODIFIED);

		/**
		 * Data inserted condition
		 * 
		 */
		when(productComparisonDao.createProduct(productsDto)).thenReturn(1L);
		productsResponse = productComparisonServiceImpl.createProduct(productsDto);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.CREATED);

		/**
		 * Exception condition
		 * 
		 */
		when(productComparisonDao.createProduct(productsDto)).thenThrow(new NullPointerException());
		productsResponse = productComparisonServiceImpl.createProduct(productsDto);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/**
	 * createProductTest is used to Test the Insert multiple record Business logic
	 * 
	 */
	@Test
	public void createProductsTest() {
		ResponseEntity<ProductResponse> productsResponse;

		List<ProductsDto> productsDtoList = new ArrayList<>();
		ProductsDto productsDto = new ProductsDto();
		productsDto.setBuyType("WEB");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://e-commerce.com/online/buy/VoltasFan1");
		productsDto.setPrice(5000);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("E Commerce");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		productsDto = new ProductsDto();
		productsDto.setBuyType("STORE");
		productsDto.setCategory("FAN");
		productsDto.setImageUrl("https://test.com/images/VoltasFan1.png");
		productsDto.setLocationUrl("https://www.google.com/maps/place/Fan+Store/@xx.xxxxxx,xx.xxxxxx");
		productsDto.setPrice(5500);
		productsDto.setProductID(1);
		productsDto.setProductName("Voltas Fan");
		productsDto.setStoreName("Fan Store");
		productsDto.setSysTmStmp(new Date());
		productsDtoList.add(productsDto);

		/**
		 * Data not inserted condition
		 * 
		 */
		when(productComparisonDao.createProducts(productsDtoList)).thenReturn(0L);
		productsResponse = productComparisonServiceImpl.createProducts(productsDtoList);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.NOT_MODIFIED);

		/**
		 * Data inserted condition
		 * 
		 */
		when(productComparisonDao.createProducts(productsDtoList)).thenReturn(1L);
		productsResponse = productComparisonServiceImpl.createProducts(productsDtoList);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.CREATED);

		/**
		 * Exception condition
		 * 
		 */
		when(productComparisonDao.createProducts(productsDtoList)).thenThrow(new NullPointerException());
		productsResponse = productComparisonServiceImpl.createProducts(productsDtoList);
		assertEquals(productsResponse.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
