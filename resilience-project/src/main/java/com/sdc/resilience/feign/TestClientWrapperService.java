package com.sdc.resilience.feign;

import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestClientWrapperService {

	private TestClient testClient;

	TestClientWrapperService(TestClient testClient) {
		this.testClient = testClient;
	}

	@CircuitBreaker(name = "testInterfaceData", fallbackMethod = "fallback")
	@Retry(name = "testRetry")
	public void getData() {
		log.error("test");
		testClient.getData();
	}

	private void fallback(Throwable e) {
		log.info("===== fallback ==== ");
	}
}
