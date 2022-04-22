package com.courier.packaging.service.order.controller;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.courier.packaging.service.order.controller.exception.CourierServiceException;
import com.courier.packaging.service.order.model.request.ItemAddress;
import com.courier.packaging.service.order.service.ServiceOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ServiceOrderController {

	@Autowired
	private ServiceOrderService serviceOrderService;

	@PostMapping(value = "place/order", produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Order service for taking the courier orders")
	public boolean placeOrder(
			@Parameter(required = true, description = "list of items and their address") @RequestBody @Validated List<ItemAddress> lstItemAddress,
			@Parameter(description = "Customer id who requestd the courier.", required = true) @RequestHeader(value = "customerId", required = true) @NotBlank(message = "customer id field cannot be blank.") String customerId)
			throws Exception {

		if (StringUtils.isBlank(customerId)) {
			throw new CourierServiceException("customerId must be provided.");
		}
		log.debug("Request accepted in Service Order");
		return serviceOrderService.placeOrderService(customerId, lstItemAddress);
	}

}
