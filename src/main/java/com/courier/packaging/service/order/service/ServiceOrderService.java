package com.courier.packaging.service.order.service;

import java.util.List;
import com.courier.packaging.service.order.model.request.ItemAddress;

public interface ServiceOrderService {
	boolean placeOrderService(String customerId, List<ItemAddress> lstItemAddress);
}