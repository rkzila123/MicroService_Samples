package com.rohit.ms.os.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rohit.ms.os.api.common.TransactionRequest;
import com.rohit.ms.os.api.common.TransactionResponse;
import com.rohit.ms.os.api.entity.Order;
import com.rohit.ms.os.api.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;
    
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        try {
			return service.saveOrder(request);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    @GetMapping
	public List<Order> getOrders(){
    	return service.getAllOrders();
		
	}
	@GetMapping("/{category}")
	public List<Order> getOrdersByCategory(@PathVariable String category){
		
		return service.getOrdersWithRespectToCategory(category);
		
	}
}
