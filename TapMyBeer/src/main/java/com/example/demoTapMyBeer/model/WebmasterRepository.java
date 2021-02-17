package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebmasterRepository extends JpaRepository<Webmaster, Long> {
	
	List<Webmaster> findByWebmasterName(String webmasterName);
	
	List<Webmaster> findByWebmasterId(String webmasterId);

}
