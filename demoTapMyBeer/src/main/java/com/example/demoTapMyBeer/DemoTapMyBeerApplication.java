package com.example.demoTapMyBeer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demoTapMyBeer.model.Address;
import com.example.demoTapMyBeer.model.AddressRepository;
import com.example.demoTapMyBeer.model.Product;
import com.example.demoTapMyBeer.model.ProductRepository;

@SpringBootApplication
public class DemoTapMyBeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTapMyBeerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(ProductRepository productRepository, AddressRepository addressRepository) {
		return args -> {
			productRepository.save(new Product("Stella Artois (6-pack)", 12.99, 20 ));
			productRepository.findAll().forEach(System.out::println);
			
			addressRepository.save(new Address(1, 63,"Broadway","Burnaby","BC","V4B2A4"));
			addressRepository.findAll().forEach(System.out::println);
		};
	}

}
