package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByName(String name);
	
}
