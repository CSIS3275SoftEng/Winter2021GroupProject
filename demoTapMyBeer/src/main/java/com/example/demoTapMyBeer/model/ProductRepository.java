package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
	List<Product> findByPrice(double price);
	List<Product> findByQuantity(int quantity);
}
