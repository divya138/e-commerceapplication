package com.ecommerceapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerceapplication.model.Orders;
import com.ecommerceapplication.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService  userService;
	@GetMapping(value="/user/{userId}")
	public List<Orders> MyOrders( @PathVariable int userId) {
		return userService.MyOrders(userId);
	}

}
