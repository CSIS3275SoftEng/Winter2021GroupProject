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

import com.example.demoTapMyBeer.model.Webmaster;
import com.example.demoTapMyBeer.model.WebmasterRepository;

@RestController
@RequestMapping("/api")
public class WebmasterController {
	
	@Autowired
	WebmasterRepository webmasterRepository;
	
	@GetMapping("/webmasters")
	public ResponseEntity<List<Webmaster>> getAllWebmasters(
			@RequestParam(required = false) String webmasterName){
		try {
			List<Webmaster> webmasters = new ArrayList<Webmaster>();
			if(webmasterName == null) {
				webmasterRepository.findAll().forEach(webmasters::add);
			} else {
				webmasterRepository.findByWebmasterName(webmasterName).forEach(webmasters::add);
			}
			if(webmasters.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(webmasters, HttpStatus.OK);                
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/webmasters/{id}")                     
	public ResponseEntity<Webmaster> getWebmasterById(@PathVariable("id") long id) {
		Optional<Webmaster> webmasterData = webmasterRepository.findById(id);         
		
		if(webmasterData.isPresent()) {
			return new ResponseEntity<>(webmasterData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/webmasters")
	public ResponseEntity<Webmaster> createWebmaster(@RequestBody Webmaster webmaster) {
		try {
			Webmaster _webmaster = webmasterRepository.save(new Webmaster(webmaster.getWebmasterName(), webmaster.getWebmasterUsername(), webmaster.getWebmasterPassword()));
			return new ResponseEntity<>(_webmaster, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/webmasters/{id}")
	public ResponseEntity<Webmaster> updateWebmaster(@PathVariable("id") long id, @RequestBody Webmaster webmaster){
		 Optional<Webmaster> webmasterData = webmasterRepository.findById(id);
		 
		 if(webmasterData.isPresent()) {
			Webmaster _webmaster = webmasterData.get();
			_webmaster.setWebmasterName(webmaster.getWebmasterName());
			_webmaster.setWebmasterUsername(webmaster.getWebmasterUsername());
			_webmaster.setWebmasterPassword(webmaster.getWebmasterPassword());
			return new ResponseEntity<> (webmasterRepository.save(_webmaster),HttpStatus.OK);
		 } else {
			 return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		 }
	}
	
	@DeleteMapping("/webmasters/{id}")
	public ResponseEntity<HttpStatus> deleteWebmaster(@PathVariable("id") long id){
		try {
			webmasterRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/webmasters")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			webmasterRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
