package com.sdc.resilience.template;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Deprecated
public class TestRestTemplate {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplateBuilder().rootUri("http://localhost:9090")
	      .build();
	}
}
