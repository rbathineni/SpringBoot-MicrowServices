package com.limits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limits.service.beans.Configuration;
import com.limits.service.beans.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfiguration retriveLimitsFromConfiguration() {
		
		return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}

}
