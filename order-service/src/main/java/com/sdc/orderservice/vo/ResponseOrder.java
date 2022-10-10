package com.sdc.orderservice.vo;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseOrder {


	private String productId;
	private Integer qty;
	private Integer unitPrice;
	private Integer totalPrice;
	private Integer stock;

	private String orderId;

	private Date createdAt;
}
