package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.domain.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer>{
	
	Summary findById(Long id);
	public List<Summary> findAll();
	public List<Summary> findFirst10ByOrderByInsertionDateDesc();

}


