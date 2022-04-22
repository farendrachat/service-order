package com.courier.packaging.service.order.model.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Address", description = "address where courier is to be done")
public class Address {
	
	@NotEmpty(message = "addressId can not be blank")
	@Schema(description ="unique address id")
	private String addressId;
	@Schema(description ="line 1 in the address")
	private String line1;
	@Schema(description ="line 2 in the address")
	private String line2;	
	@Schema(description ="city in the address")
	private String city;
	@Schema(description ="state in the address")
	private String state;
	@Schema(description ="warehouse in this zone will do the courier")
	private String zone;
	

}
