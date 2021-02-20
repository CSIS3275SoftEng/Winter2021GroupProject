package com.example.demoTapMyBeer.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebmasterRepository extends JpaRepository<Webmaster, Long> {
	
	List<Webmaster> findByWebmasterName(String webmasterName);
	
	Optional<Webmaster> findByWebmasterId(String webmasterId);
	
	Boolean existsByWebmasterId(String webmasterId);
	
}
