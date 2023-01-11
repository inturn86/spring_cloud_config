package com.sdc.resilience.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Deprecated
public class ExternalAPICaller {

	private final RestTemplate restTemplate;

	public ExternalAPICaller(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
