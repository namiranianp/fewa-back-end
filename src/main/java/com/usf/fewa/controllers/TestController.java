package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.TestService;

@RestController
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
	TestService testService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/test", produces = "application/json")
	public String home(@RequestParam(value = "msg", defaultValue = "Hello, World!") String msg) {
		return testService.returnService(msg);
	}

}
