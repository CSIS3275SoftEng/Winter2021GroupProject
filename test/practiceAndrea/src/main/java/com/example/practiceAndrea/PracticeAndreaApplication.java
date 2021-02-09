package com.example.practiceAndrea;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.practiceAndrea.model.Course;
import com.example.practiceAndrea.model.CourseRepository;

@SpringBootApplication // means that if I run this application, it will start the servers and necessary steps to run the web applications
public class PracticeAndreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeAndreaApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(CourseRepository repository) {
		return args -> {
			repository.save(new Course("CSIS2175", "Adv Soft Dev"));
			repository.save(new Course("CSIS3275", "Soft Eng"));
			repository.save(new Course("CSIS1275", "Java"));
			repository.findAll().forEach(System.out::println);
		};
	} 

}
