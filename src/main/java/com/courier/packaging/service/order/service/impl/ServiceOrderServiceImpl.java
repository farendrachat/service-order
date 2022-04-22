package com.courier.packaging.service.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.courier.packaging.service.order.model.request.ItemAddress;
import com.courier.packaging.service.order.service.ServiceOrderService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ServiceOrderServiceImpl")
public class ServiceOrderServiceImpl implements ServiceOrderService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${serviceOrder.post.restURL}")
	String serviceOrderPostURL;

	@CircuitBreaker(name = "resilence", fallbackMethod = "defaultPlaceOrderService")
	public boolean placeOrderService(String customerId, List<ItemAddress> lstItemAddress) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<List<ItemAddress>> requestBody = new HttpEntity<>(lstItemAddress, headers);
		ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(serviceOrderPostURL, requestBody,
				Boolean.class);
		if (responseEntity.toString().isEmpty()) {
			log.debug("responseentity is empty");
		}
		return true;
	}

	private boolean defaultPlaceOrderService(String customerId, List<ItemAddress> lstItemAddress) {
		log.debug(
				"Some problem with Service Package for customer id :" + customerId + " Please try after sometime");
		return false;
	}

}