package com.currency.conversion.service;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal totalCalAmount;
	private int port;
	
	public CurrencyConversionBean() {}
	
	public CurrencyConversionBean(long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalCalAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.totalCalAmount = totalCalAmount;
		this.port = port;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getTotalCalAmount() {
		return totalCalAmount;
	}
	public void setTotalCalAmount(BigDecimal totalCalAmount) {
		this.totalCalAmount = totalCalAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return String.format(
				"CurrencyConversionBean [id=%s, from=%s, to=%s, quantity=%s, conversionMultiple=%s, totalCalAmount=%s, port=%s]",
				id, from, to, quantity, conversionMultiple, totalCalAmount, port);
	}
	
	
}
