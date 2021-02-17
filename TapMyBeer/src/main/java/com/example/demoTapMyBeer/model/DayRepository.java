package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day, Long>{

	List<Day> findByDayNumber(int dayNum);
}

