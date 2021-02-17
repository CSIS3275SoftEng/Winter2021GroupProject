package com.example.demoTapMyBeer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends  JpaRepository<Month, Long>{

	List<Month> findByMonthName(String monthName);
	List<Month> findByMonthNum(int monthNum);
}
