package com.rohit.ms.ps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rohit.ms.ps.api.entity.Payment;
import com.rohit.ms.ps.api.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) {
        try {
			return service.doPayment(payment);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			return null;
		}
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId){
              try {
				return service.findPaymentHistoryByOrderId(orderId);
			} catch (JsonProcessingException e) {
				
				e.printStackTrace();
				return null;
			}
    }


}
