package com.sdc.orderservice.service;

import com.sdc.orderservice.dto.OrderDto;
import com.sdc.orderservice.jpa.OrderEntity;

public interface OrderService {


	OrderDto createOrder(OrderDto orderDetails);
	OrderDto getOrderByOrderId(String orderId);
	Iterable<OrderEntity> getOrdersByUserId(String userId);
}
