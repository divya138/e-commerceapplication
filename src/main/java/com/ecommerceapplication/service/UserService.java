package com.ecommerceapplication.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerceapplication.model.Orders;
import com.ecommerceapplication.model.User;
import com.ecommerceapplication.repositroy.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	public UserRepository userRepositroy;
	
	public List<Orders> MyOrders(int userId) {
		
		User orders = userRepositroy.findByUserId(userId);

		return orders.getOrders();
	}

}
