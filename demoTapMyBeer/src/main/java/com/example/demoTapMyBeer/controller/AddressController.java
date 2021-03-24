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

import com.example.demoTapMyBeer.model.Address;
import com.example.demoTapMyBeer.model.AddressRepository;







@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	AddressRepository addressRepository;
	
	//get all addresses
	/*public List<Address> getAllAddress(){
		return this.addrRepository.findAll();
	}*/
	
	@GetMapping("/addresses")
	public ResponseEntity<List<Address>> getAllAddress(
			@RequestParam(required = false) String street){
		try {
			List<Address> addresses = new ArrayList<Address>();
			if(street == null) {
				addressRepository.findAll().forEach(addresses::add);
				
			}else {
				addressRepository.findByStreet(street).forEach(addresses::add);

			}if(addresses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(addresses,HttpStatus.OK );
		
		}catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR );

			
		}
	}
	
	//get Address by Id
	@GetMapping("/addresses/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") long id){
		Optional<Address> addrData = addressRepository.findById(id);
	
		if(addrData.isPresent()) {
			return new ResponseEntity<>(addrData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/addresses")
	public ResponseEntity<Address> createAddress(@RequestBody Address address){
		try {
			Address _addr = addressRepository.save(new Address(address.getCustomerId(), address.getAddNo(), 
					address.getStreet(), address.getCity(), address.getProvince(), address.getPostalCode()));
			
			return new ResponseEntity<>(_addr, HttpStatus.CREATED);
		}
		
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/addresses/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") long id, @RequestBody Address address) {
		Optional<Address> addrData = addressRepository.findById(id);

		if (addrData.isPresent()) {
			Address _addr = addrData.get();
			
			_addr.setCustomerId(address.getCustomerId());
			
			_addr.setAddNo(address.getAddNo());
			
			_addr.setStreet(address.getStreet());
			
			_addr.setCity(address.getCity());
			
			_addr.setProvince(address.getProvince());
			
			_addr.setPostalCode(address.getPostalCode());
		
			
			return new ResponseEntity<>(addressRepository.save(_addr), HttpStatus.OK);
		} 
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	@DeleteMapping("/addresses/{id}")
	public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") long id) {
		try {
			addressRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/addresses")
	public ResponseEntity<HttpStatus> deleteAllAddresses() {
		try {
			addressRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	
	
}
	
