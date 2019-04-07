package com.rmpksoft.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rmpksoft.demo.model.Order;
import com.rmpksoft.demo.service.OrderService;

@RestController
public class OrderController {
	
	private OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAllOrders() {
    	 List<Order> list = orderService.getAllOrders();
        if(list.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
    }
	
	@GetMapping("/order/{orderNumber}")
	public ResponseEntity<Order> getOrder(@PathVariable("orderNumber") long orderNumber) {
		Optional<Order> orderOptional = orderService.findByOrderId(orderNumber);
		if (orderOptional.isPresent()) {
			Order order = orderOptional.get();
			return ResponseEntity.ok(order);
		}
		return ResponseEntity.notFound().build();
	}
}
