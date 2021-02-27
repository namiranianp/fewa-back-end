package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.JsonTestService;

@RestController
@RequestMapping(value = "/jsontest")
public class JsonTestController {
	
	@Autowired
	JsonTestService jsonTestService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/jsontest", produces = "application/json")
	public String home() {
		return jsonTestService.returnService();
	}

}
