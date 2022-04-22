package com.courier.packaging.service.order.model.request;

import javax.validation.constraints.NotEmpty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Package", description = "package to club the items to be delivered to an address")
public class Package {
	
	@NotEmpty(message = "packageId can not be blank")
	@Schema(description ="unique packageId of the courier")
	private String packageId;	
	@NotEmpty(message = "addressId can not be blank")
	@Schema(description ="unique addressId for the address of courier")
	private String addressId;
	@NotEmpty(message = "itemId can not be blank")
	@Schema(description ="unique itemId for the item to be couriered")
	private String itemId;
}
