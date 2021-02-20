package com.example.demoTapMyBeer.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	 
		
	    Optional<Payment> findByPayId(String payId);
	
		List<Payment> findByPayType (String payType);
		
		
}
