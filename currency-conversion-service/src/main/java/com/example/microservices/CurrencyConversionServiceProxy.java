package com.example.microservices;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="curency-exchange-service")
@FeignClient(name="netfilx-zuul-api-gateway-server")
@RibbonClient(name="curency-exchange-service")
public interface CurrencyConversionServiceProxy {
	
	//@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	@GetMapping(path="curency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public List<CurrencyConverter> retrieveExchangeValue(@PathVariable("from") String from , @PathVariable("to") String to);
	

}
