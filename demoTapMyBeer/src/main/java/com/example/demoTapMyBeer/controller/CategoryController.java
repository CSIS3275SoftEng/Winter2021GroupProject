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

import com.example.demoTapMyBeer.model.Category;
import com.example.demoTapMyBeer.model.CategoryRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String name) {
		try {
			List<Category> categories = new ArrayList<Category>();
			if(name == null)
				categoryRepository.findAll().forEach(categories::add);
			else
				categoryRepository.findByName(name).forEach(categories::add);
			
			if (categories.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(categories,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
		Optional<Category> categoryData = categoryRepository.findById(id);
		
		if(categoryData.isPresent()) {
			return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/categories")
	public ResponseEntity<Category> createTutorial(@RequestBody Category category) {
		try {
			Category _category = categoryRepository.save(new Category(category.getName()));
			return new ResponseEntity<>(_category, HttpStatus.CREATED);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
		Optional<Category> categoryData = categoryRepository.findById(id);
		
		if(categoryData.isPresent()) {
			Category _category = categoryData.get();
			return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") long id) {
		try {
			categoryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/categories")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			categoryRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
