package com.example.demoTapMyBeer.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

	List<Warehouse> findByName(String name);

	List<Warehouse> findBywAddress(String wAddress);
	
	List<Warehouse> findBynumInventory(String numInventory);
	
}
