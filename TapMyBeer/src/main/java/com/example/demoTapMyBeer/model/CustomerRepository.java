package com.example.demoTapMyBeer.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByCustomerId(String customerId);
	
	List<Customer> findByCustomerFName(String customerFName);
	
	List<Customer> findByCustomerLName(String customerLName);
	
	Boolean existsByCustomerId(String customerId);
}
