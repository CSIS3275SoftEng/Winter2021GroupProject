package com.example.demoTapMyBeer.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findById(long product_id);

	List<Product> findByName(String name);
	
	List<Product> findByPrice(double price);
	
	List<Product> findByQuantity(int quantity);
	
	List<Product> findProductByCategory(long product_id);

}
