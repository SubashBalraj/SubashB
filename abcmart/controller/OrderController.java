package com.abcmart.controller;

import com.abcmart.service.OrderService;

public class OrderController {
	public String buyProduct(int productId, int quantity) {
		
		OrderService orderService = new OrderService();
		double orderAmount = orderService.placeOrder(productId,quantity);
		
		return "Oredr successfully placed.OrdrAmount = "+orderAmount;
	}

}
