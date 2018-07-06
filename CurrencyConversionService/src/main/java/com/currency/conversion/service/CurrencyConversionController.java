package com.currency.conversion.service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		
		CurrencyConversionBean responseBean = responseEntity.getBody();
		return new CurrencyConversionBean(responseBean.getId(),
				from,
				to,
				responseBean.getConversionMultiple(),
				quantity,
				quantity.multiply(responseBean.getConversionMultiple()),responseBean.getPort());
	}
	
	@GetMapping("/currency-conversion-proxy/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyThroughFeignProxy(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversionBean responseBean = proxy.retriveExchangeValue(from, to);
		logger.info("Response Bean -> {}",responseBean);
		
		return new CurrencyConversionBean(responseBean.getId(),
				from,
				to,
				responseBean.getConversionMultiple(),
				quantity,
				quantity.multiply(responseBean.getConversionMultiple()),responseBean.getPort());
	}
}
