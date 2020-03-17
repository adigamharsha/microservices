package com.example.microservices;

import java.math.BigDecimal;

public class CurrencyConverter {

	private Long id;
	private BigDecimal conversionMultiple;
	private String from;
	private String to;
	private String quantity;	
	private String calculatedAmount;
	private int port;

	public CurrencyConverter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyConverter(Long id, String from, String to, String quantity, BigDecimal conversionMultiple,
			String calculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getconversionMultiple() {
		return conversionMultiple;
	}

	public void setconversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(String calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
