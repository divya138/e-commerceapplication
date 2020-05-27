package com.ecommerceapplication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapplication.model.Orders;
import com.ecommerceapplication.service.OrdersService;

@RestController
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	@GetMapping(value="/orders/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Optional<Orders> order=ordersService.getByOrderId(id);
		return new  ResponseEntity<Object>(order,HttpStatus.OK);
	}

}
