package com.example.demoTapMyBeer.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WebmasterRepository extends JpaRepository<Webmaster, Long> {
	
	Optional<Webmaster> findByWebmasterName(String webmasterName);
	
	Optional<Webmaster> findByWebmasterId(String webmasterId);

}
