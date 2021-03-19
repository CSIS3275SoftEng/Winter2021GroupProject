package com.example.demoTapMyBeer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Order;
import com.example.demoTapMyBeer.model.OrderRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(@RequestParam(required = false) Long orderId) {
		try {
			List<Order> orders = new ArrayList<Order>();
			if(orderId == null)
				orderRepository.findAll().forEach(orders::add);
			else
				orderRepository.findByOrderId(orderId).forEach(orders::add);
			
			if (orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(orders,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId) {
		Optional<Order> orderData = orderRepository.findById(orderId);
		
		if(orderData.isPresent()) {
			return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		try {
			Order _order = orderRepository.save(new Order(order.getYearId(), 
					order.getMonthId(), order.getDayId(), order.getQuantity()));
			return new ResponseEntity<>(_order, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody Order order) {
		Optional<Order> orderData = orderRepository.findById(orderId);
		
		if(orderData.isPresent()) {
			Order _order = orderData.get();
			_order.setDayId(order.getDayId());
			_order.setQuantity(order.getQuantity());
			_order.setDayId(order.getDayId());
			return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("orderId") Long orderId) {
		try {
			orderRepository.deleteById(orderId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/orders")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			orderRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
