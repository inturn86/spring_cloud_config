package com.sdc.resilience.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdc.resilience.api.ExternalAPICaller;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class ResilientAppController {

	@PostMapping("getData")
	public void getData() throws Exception{

		Random r1 = new Random();

		int randomNumber = r1.nextInt(10) + 1;
		System.out.println("get Data random data = " + randomNumber);

		if(randomNumber >= 5) {
			throw new Exception();
		}
	}
}
