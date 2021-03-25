package com.example.demoTapMyBeer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoTapMyBeer.model.Category;
import com.example.demoTapMyBeer.model.CategoryRepository;
import com.example.demoTapMyBeer.model.Product;
import com.example.demoTapMyBeer.model.ProductRepository;
import com.example.demoTapMyBeer.response.MessageResponse;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AssignedCategoryController {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	// NEW API
	@GetMapping("/{pid}/category")
	public ResponseEntity<?> findCategoryByProduct(@PathVariable("pid") Long pid, @RequestParam(required = false) Boolean assigned) {
		try {
			Optional<Product> productData = productRepository.findById(pid);
			if (productData.isPresent()) {
				Product product = productData.get();
				Category assignedCategory = product.getCategory();
				if(assigned) {
					return new ResponseEntity<>(assignedCategory, HttpStatus.OK);
				}
				else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			} else {
				MessageResponse msg = new MessageResponse("This product does not exist.");
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
		
	
}
