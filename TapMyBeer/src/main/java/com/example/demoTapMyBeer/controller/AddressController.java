package com.example.demoTapMyBeer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Address;
import com.example.demoTapMyBeer.model.AddressRepository;







@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	AddressRepository addrRepository;
	
	//get all addresses
	public List<Address> getAllAddress(){
		return this.addrRepository.findAll();
	}
	
	
	//get Address by Id
	@GetMapping("/addresses/{id}")
	public ResponseEntity<Address> getCourseById(@PathVariable("id") long id){
		Optional<Address> addrData = addrRepository.findById(id);
	
		if(addrData.isPresent()) {
			return new ResponseEntity<>(addrData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
	
