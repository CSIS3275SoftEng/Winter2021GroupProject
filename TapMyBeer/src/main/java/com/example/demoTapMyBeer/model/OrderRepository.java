package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByYearId(long yearId);

	List<Order> findByMonthId(long monthId);
	
	List<Order> findByDayId(long dayId);
	
	List<Order> findByProductId(long productId);
	
	List<Order> findByQuantity(int quantity);
	
}
