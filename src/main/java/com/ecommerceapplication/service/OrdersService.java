package com.ecommerceapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerceapplication.model.Orders;
import com.ecommerceapplication.repositroy.OrderRepository;

@Service
@Transactional
public class OrdersService {
	@Autowired
	 private OrderRepository orderRepositroy;
	public Optional<Orders> getByOrderId(int id){
		return orderRepositroy.findById(id);
	}
	

}
