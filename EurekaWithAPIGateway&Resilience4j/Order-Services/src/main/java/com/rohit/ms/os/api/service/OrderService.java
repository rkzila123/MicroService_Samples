package com.rohit.ms.os.api.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohit.ms.os.api.common.Payment;
import com.rohit.ms.os.api.common.TransactionRequest;
import com.rohit.ms.os.api.common.TransactionResponse;
import com.rohit.ms.os.api.entity.Order;
import com.rohit.ms.os.api.repository.OrderRepository;



@Service
public class OrderService {

    Logger logger= LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderRepository repository;
    @Autowired
    @Lazy
    private RestTemplate template;

    //@Value("${microservice.payment-service.endpoints.endpoint.uri}")
   // private String endPointUrl;

    public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        //rest call
        logger.info("Order-Service Request : {}",new ObjectMapper().writeValueAsString(request));
        Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment"
, payment, Payment.class);
        if(paymentResponse!=null) {
        	response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api , order added to cart";
        	logger.info("Order Service getting Response from Payment-Service : {}" , new ObjectMapper().writeValueAsString(response));
        	repository.save(order);
        	return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
        }else {
        	return new TransactionResponse(order, 0 , null, "paymentResponse is null");
        }
    }
    
    public Order saveOrders(Order order) {
    	return repository.save(order);
    }

	public List<Order> getAllOrders() {
		return repository.findAll();
	}

	public List<Order> getOrdersWithRespectToCategory(String category) {
		return repository.findByCategory(category);
	}
}
