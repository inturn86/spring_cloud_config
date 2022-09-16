package com.sdc.secondservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class SecondServerController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome second Service ";
	}
}
