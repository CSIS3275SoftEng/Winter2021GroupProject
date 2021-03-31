package com.example.demoTapMyBeer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoTapMyBeer.model.Product;
import com.example.demoTapMyBeer.model.ProductRepository;
import com.example.demoTapMyBeer.model.Seller;
import com.example.demoTapMyBeer.model.SellerRepository;
import com.example.demoTapMyBeer.response.MessageResponse;

@RestController
@RequestMapping("/api")
public class ProductBySellerController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SellerRepository sellerRepository;
	
	// SELLER - PRODUCT Relationship
	// NEW API
	@GetMapping("/{pid}/seller")
	public ResponseEntity<?> findProductBySeller(@PathVariable("pid") Long pid, @RequestParam(required = false) Boolean hasSeller) {
		try {
			Optional<Product> productData = productRepository.findById(pid);
			if (productData.isPresent()) {
				Product product = productData.get();
				Seller productSeller = product.getSeller();
				if(hasSeller) {
					return new ResponseEntity<>(productSeller, HttpStatus.OK);
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
