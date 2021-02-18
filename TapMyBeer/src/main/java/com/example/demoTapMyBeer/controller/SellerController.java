package com.example.demoTapMyBeer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Seller;
import com.example.demoTapMyBeer.model.SellerRepository;

@RestController
@RequestMapping("/api")
public class SellerController {
	
	@Autowired
	SellerRepository sellerRepository;
	
	@GetMapping("/sellers")
	public ResponseEntity<List<Seller>> getAllSellers(
			@RequestParam(required = false) String name){
		try {
			List<Seller> sellers = new ArrayList<Seller>();
			if(name == null) {
				sellerRepository.findAll().forEach(sellers::add);
			} else {
				sellerRepository.findBySellerName(name).forEach(sellers::add);
			}
			if(sellers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(sellers, HttpStatus.OK);                
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/sellers/{id}")                     
	public ResponseEntity<Seller> getSellerById(@PathVariable("id") long id) {
		Optional<Seller> sellerData = sellerRepository.findById(id);         
		
		if(sellerData.isPresent()) {
			return new ResponseEntity<>(sellerData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/sellers")
	public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
		try {
			Seller _seller = sellerRepository.save(new Seller(seller.getSellerName(), seller.getSellerUsername(), seller.getSellerPassword()));
			return new ResponseEntity<>(_seller, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/sellers/{id}")
	public ResponseEntity<Seller> updateSeller(@PathVariable("id") long id, @RequestBody Seller seller){
		 Optional<Seller> sellerData = sellerRepository.findById(id);
		 
		 if(sellerData.isPresent()) {
			Seller _seller = sellerData.get();
			_seller.setSellerName(seller.getSellerName());
			_seller.setSellerUsername(seller.getSellerUsername());
			_seller.setSellerPassword(seller.getSellerPassword());
			return new ResponseEntity<> (sellerRepository.save(_seller),HttpStatus.OK);
		 } else {
			 return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		 }
	}
	
	@DeleteMapping("/sellers/{id}")
	public ResponseEntity<HttpStatus> deleteSeller(@PathVariable("id") long id){
		try {
			sellerRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/sellers")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			sellerRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
