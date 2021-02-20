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

import com.example.demoTapMyBeer.model.Webmaster;
import com.example.demoTapMyBeer.model.WebmasterRepository;
import com.example.demoTapMyBeer.request.WebmasterLoginRequest;
import com.example.demoTapMyBeer.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class WebmasterLoginController {
	
	@Autowired
	WebmasterRepository webmasterRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody WebmasterLoginRequest loginRequest) {
		
		try {
			Optional<Webmaster> webmasterData = webmasterRepository.findByWebmasterId(loginRequest.getWebmasterId());
			if(webmasterData.isPresent()) {
				String password = webmasterData.get().getWebmasterPassword();
				if(password.equals(loginRequest.getWebmPassword())) {
					return new ResponseEntity<>(webmasterData.get(), HttpStatus.OK);
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
