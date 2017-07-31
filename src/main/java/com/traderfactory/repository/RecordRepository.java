package com.traderfactory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traderfactory.domain.Person;
import com.traderfactory.domain.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

	Person findByRecordId(Long id);
	public List<Record> findAll();

}
