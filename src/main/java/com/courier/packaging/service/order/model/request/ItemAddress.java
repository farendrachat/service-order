package com.courier.packaging.service.order.model.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ItemAddress", description = "item details and address details for courier")

public class ItemAddress {
	
	@NotEmpty(message = "itemId can not be blank")
	@Schema(description ="unique item id")
	private String itemId;
	@Schema(description ="name of the item")
	private String itemName	;
	@Schema(description ="quantity of the item to deliver")
	private String quantity;
	@Schema(description ="price of the item")
	private String price;
	@Schema(description ="total payment to be done")
	private String total;

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
