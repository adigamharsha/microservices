package com.example.microservices;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionServiceProxy proxy;
	@GetMapping("/currency-conversion/from/{from}/to/{to}/{quantity}")
	public List<CurrencyConverter>	 retrieveCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		List<CurrencyConverter> finalList = new ArrayList<CurrencyConverter> ();

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", "USD");
		uriVariables.put("to", "INR");

		ResponseEntity<CurrencyConverter[]> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverter[].class, uriVariables);
		List<CurrencyConverter> body = Arrays.asList(response.getBody());
		body.forEach(currency -> finalList.add(new CurrencyConverter(currency.getId(), from, to, quantity.toString(), currency.getconversionMultiple(),
				quantity.multiply(currency.getconversionMultiple()).toString(), currency.getPort())));
		
		return finalList;
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/{quantity}")
	public List<CurrencyConverter>	 retrieveCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		List<CurrencyConverter> finalList = new ArrayList<CurrencyConverter> ();

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", "USD");
		uriVariables.put("to", "INR");

		List<CurrencyConverter> response = proxy.retrieveExchangeValue(from, to);
		//List<CurrencyConverter> body = response.getBody();
		response.forEach(currency -> finalList.add(new CurrencyConverter(currency.getId(), from, to, quantity.toString(), currency.getconversionMultiple(),
				quantity.multiply(currency.getconversionMultiple()).toString(), currency.getPort())));
		
		return finalList;
	}

}
