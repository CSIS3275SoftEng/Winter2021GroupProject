package com.example.demoTapMyBeer.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	List<Seller> findBySellerName(String sellerName);
	
	Optional<Seller> findBySellerId(String sellerId);
	
}
