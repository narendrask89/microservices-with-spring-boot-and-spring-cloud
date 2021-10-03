package com.nandu.microservices.currencyexchangeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CircuitBreakerController {

	@GetMapping("/sample-api")
	// @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	// @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	// @RateLimiter(name = "default")
	// @Bulkhead(name = "sample-api")
	// 10s => 10000 calls to the sample api
	public String sampleApi() {
		log.info("Sample api call received");
		// ResponseEntity<String> forEntity = new
		// RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
		// String.class);
		// return forEntity.getBody();
		return "sample-api";
	}

	public String hardcodedResponse(Exception ex) {
		return "fallback-response " + ex.getMessage();
	}
}
