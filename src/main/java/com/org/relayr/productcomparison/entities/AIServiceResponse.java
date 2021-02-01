package com.org.relayr.productcomparison.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @Created by Arun Raja
 * Since 2/1/2021
 * 
 * AIServiceResponse is used to hold Response from AI Product Review Service
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class AIServiceResponse {

	@JsonProperty("ai_services_map")
	Map<String,Integer> aiServiceMap;
}
