package com.rmpksoft.demo.service;

import java.util.List;
import java.util.Optional;

import com.rmpksoft.demo.model.Order;

public interface OrderService {
	public List<Order> getAllOrders(); 
	public Optional<Order> findByOrderId(long orderNumber);
	public Optional<Order> findByName(String name);
}
