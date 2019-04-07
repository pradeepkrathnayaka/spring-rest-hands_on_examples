package com.rmpksoft.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rmpksoft.demo.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> getAllOrders() {
		List<Order> ordersList = new ArrayList<>();
		ordersList.add(new Order(1L, new Date(), "11"));
		ordersList.add(new Order(2L, new Date(), "22"));
		ordersList.add(new Order(3L, new Date(), "33"));
		ordersList.add(new Order(4L, new Date(), "44"));
		ordersList.add(new Order(5L, new Date(), "55"));
		ordersList.add(new Order(6L, new Date(), "66"));
		ordersList.add(new Order(7L, new Date(), "77"));
		ordersList.add(new Order(8L, new Date(), "88"));
		ordersList.add(new Order(9L, new Date(), "99"));
		ordersList.add(null);
		
		
		List<Order> list = Optional.ofNullable(ordersList)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull).collect(Collectors.toList());

		list.forEach(o -> System.out.println(o.getOrderNumber()));
		
		return list;
	}

	@Override
	public Optional<Order> findByOrderId(long orderNumber) {
		try {
			Optional<Order> matchingOrder = getAllOrders().parallelStream().
				    filter(o -> o.getOrderNumber().equals(orderNumber)).
				    findFirst();
            return Optional.ofNullable(matchingOrder.get());
        } catch (Exception e) {
            return Optional.empty();
        }
	}

	@Override
	public Optional<Order> findByName(String name) {
		try {
			Optional<Order> matchingOrder = getAllOrders().stream().
				    filter(o -> o.getItemName().equals(name)).
				    findFirst();
            return Optional.ofNullable(matchingOrder.get());
        } catch (Exception e) {
            return Optional.empty();
        }
	}

}
