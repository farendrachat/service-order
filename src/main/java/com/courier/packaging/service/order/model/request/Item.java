package com.courier.packaging.service.order.model.request;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Item", description = "item details that need to be couriered")

public class Item {
	@NotEmpty(message = "addressId can not be blank")
	@Schema(description ="address to which the item is to be delivered")
	private String addressId;
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
}
