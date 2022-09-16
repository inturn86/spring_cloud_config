package com.sdc.firstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class FirstServerController {

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome first Service ";
	}
}
