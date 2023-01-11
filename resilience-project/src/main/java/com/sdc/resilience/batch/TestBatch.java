package com.sdc.resilience.batch;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sdc.resilience.feign.TestClient;
import com.sdc.resilience.feign.TestClientWrapperService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestBatch {

	private TestClient testClient;

	private TestClientWrapperService testClientWrapperService;


	public TestBatch(TestClient testClient, TestClientWrapperService testClientWrapperService) {
		this.testClient = testClient;
		this.testClientWrapperService = testClientWrapperService;
	}

	@Scheduled(initialDelay = 1000, fixedDelay = 3000)
	public void batch() {
		log.info("Start bat!ch");

		testClientWrapperService.getData();

		log.info("End batch");
	}
}
