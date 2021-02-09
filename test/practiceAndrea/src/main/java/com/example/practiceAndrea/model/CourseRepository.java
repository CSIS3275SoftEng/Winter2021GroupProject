package com.example.practiceAndrea.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByTitle(String title);
	
	List<Course> findByCode(String code);

}
