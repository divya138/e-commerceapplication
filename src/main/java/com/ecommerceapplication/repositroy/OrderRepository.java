package com.ecommerceapplication.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerceapplication.model.Orders;
@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
	public Orders findByOrderId(int id);

}
