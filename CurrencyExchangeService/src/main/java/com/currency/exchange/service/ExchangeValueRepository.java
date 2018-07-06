package com.currency.exchange.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.exchange.service.model.ExchangeValue;
 
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findByFromAndTo(String from,String to);

}
