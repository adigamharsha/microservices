package com.example.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration; 
	
	@GetMapping(path="/retrieveLimitsConfiguration")
	public LimitsConfiguration retrieveLimitsConfiguration() {
		
		return new LimitsConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
	}

}
