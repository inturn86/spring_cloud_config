package com.sdc.resilience.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(url = "${interface.test.url}", name="testClient")
public interface TestClient {

	@PostMapping(value ="/getData",  produces = { MediaType.APPLICATION_JSON_VALUE})
	public void getData();
}
