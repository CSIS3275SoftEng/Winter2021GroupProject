package com.example.practiceAndrea.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceAndrea.model.Course;
import com.example.practiceAndrea.model.CourseRepository;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired // creates object automatically to handle db
	CourseRepository courseRepository;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses(@RequestParam(required = false) String title) {
		
		try {
			List<Course> courses = new ArrayList<Course>();
			if(title == null) {
				courseRepository.findAll().forEach(courses::add);
			} else {
				courseRepository.findByTitle(title).forEach(courses::add);
			}
			if(courses.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(courses, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") long id){
		Optional<Course> courseData = courseRepository.findById(id);
		
		if(courseData.isPresent()) {
			return new ResponseEntity<>(courseData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
