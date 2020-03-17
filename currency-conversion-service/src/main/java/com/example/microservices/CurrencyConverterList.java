package com.example.microservices;

import java.util.List;

public class CurrencyConverterList {
	
	private List<CurrencyConverter> currencyConverter;
	
	

	public CurrencyConverterList() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CurrencyConverterList(List<CurrencyConverter> currencyConverter) {
		super();
		this.currencyConverter = currencyConverter;
	}


	public List<CurrencyConverter> getCurrencyConverter() {
		return currencyConverter;
	}

	public void setCurrencyConverter(List<CurrencyConverter> currencyConverter) {
		this.currencyConverter = currencyConverter;
	}
	
	

}
