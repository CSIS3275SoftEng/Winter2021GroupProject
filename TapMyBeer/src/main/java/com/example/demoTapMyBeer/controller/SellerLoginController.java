package com.example.demoTapMyBeer.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Seller;
import com.example.demoTapMyBeer.model.SellerRepository;
import com.example.demoTapMyBeer.request.SellerLoginRequest;
import com.example.demoTapMyBeer.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SellerLoginController {
	
	@Autowired
	SellerRepository sellerRepository;
	
	@PostMapping("/loginSeller")
	public ResponseEntity<?> login(@Valid @RequestBody SellerLoginRequest loginRequest) {
		
		try {
			Optional<Seller> sellerData = sellerRepository.findBySellerId(loginRequest.getSellerId());
			if(sellerData.isPresent()) {
				String password = sellerData.get().getSellerPassword();
				if(password.equals(loginRequest.getSellerPassword())) {
					return new ResponseEntity<>(sellerData.get(), HttpStatus.OK);
				}
				MessageResponse msg = new MessageResponse("Incorrect password");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
			MessageResponse msg = new MessageResponse("Invalid user");
			return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			MessageResponse msg = new MessageResponse("Server Error");
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
