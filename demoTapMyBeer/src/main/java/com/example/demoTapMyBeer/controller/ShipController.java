package com.example.demoTapMyBeer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.ShipRepository;
import com.example.demoTapMyBeer.model.Shipping;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api") 
public class ShipController {


	@Autowired
	ShipRepository shipRepository;
	
	@GetMapping("/shippings")
	public ResponseEntity<List<Shipping>> getAllShipType(
			@RequestParam(required = false) String shipType){
		try {
			List<Shipping> shippings = new ArrayList<Shipping>();
			if(shipType == null) {
				shipRepository.findAll().forEach(shippings::add);
				
			}else {
				shipRepository.findByshipType(shipType).forEach(shippings::add);

			}if(shippings.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(shippings,HttpStatus.OK );
		
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR );

			
		}
	}
	
	@GetMapping("/shippings/{id}")
	public ResponseEntity<Shipping> getShippingById(@PathVariable("id") long id){
		Optional<Shipping> shipData = shipRepository.findById(id);
	
		if(shipData.isPresent()) {
			return new ResponseEntity<>(shipData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/shippings")
	public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shippings){
		try {
			Shipping _ship = shipRepository.save(new Shipping(
					
					shippings.getShipType(), 
					shippings.getShipFee()));
			
			return new ResponseEntity<>(_ship, HttpStatus.CREATED);
		}
		
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/shippings/{id}")
	public ResponseEntity<Shipping> updateShipping(@PathVariable("id") long id, @RequestBody Shipping shippings) {
		Optional<Shipping> shipData = shipRepository.findById(id);

		if (shipData.isPresent()) {
			Shipping _ship = shipData.get();
			
			_ship.setShipType(shippings.getShipType());
			_ship.setShipFee(shippings.getShipFee());
			
			return new ResponseEntity<>(shipRepository.save(_ship), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/shippings/{id}")
	public ResponseEntity<HttpStatus> deleteShipping(@PathVariable("id") long id) {
		try {
			shipRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/shippings")
	public ResponseEntity<HttpStatus> deleteAllShippings() {
		try {
			shipRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
	
	
	
	
	
	
	
}
