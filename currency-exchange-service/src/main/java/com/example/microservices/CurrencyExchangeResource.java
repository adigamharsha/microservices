package com.example.microservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeResource {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public Environment environment;
	
	@Autowired
	public ExchangeValueRepository repository;
	
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public List<ExchangeValue> retrieveExchangeValue(@PathVariable String from , @PathVariable String to) {
		
		System.out.println("In method()");		
//		ExchangeValueRepositoryExchangeValue value = new ExchangeValue(1000L, BigDecimal.valueOf(65) ,"USD", "INR" );
//		value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
//		return value;
		
		 List<ExchangeValue> list = repository.findByFromAndTo(from, to);
		 list.forEach(value -> value.setPort(Integer.parseInt(environment.getProperty("local.server.port"))));
		 logger.info("->{}" , list);
		 return list;
	}
	

}
