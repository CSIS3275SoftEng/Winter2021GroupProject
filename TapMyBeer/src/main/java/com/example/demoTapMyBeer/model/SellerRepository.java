package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	List<Seller> findBySellerName(String sellerName);
	
	List<Seller> findBySellerId(String sellerId);
	
}
