package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Shipping, Long>  {


	List<Shipping> findByshipType(String shipType);
	
	
}
