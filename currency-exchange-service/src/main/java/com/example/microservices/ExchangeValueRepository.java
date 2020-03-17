package com.example.microservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
		List<ExchangeValue> findByFromAndTo(String from , String to);

}
