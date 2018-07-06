package com.currency.exchange.service;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.service.model.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment environment;
	
	@Autowired
	ExchangeValueRepository repository;
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		//ExchangeValue  exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		ExchangeValue  exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		
		logger.info("ExchangeValue :{}",exchangeValue);
		
		return exchangeValue;
	}
}
