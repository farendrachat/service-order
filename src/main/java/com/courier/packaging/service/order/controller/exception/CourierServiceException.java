package com.courier.packaging.service.order.controller.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourierServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CourierServiceException(String errMsg){
		super(errMsg);
       log.warn("Exception in SERVICE ORDER is:"+errMsg);
	}
}