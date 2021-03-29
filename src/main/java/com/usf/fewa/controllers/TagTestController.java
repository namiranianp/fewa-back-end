package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.JsonTestService;
import com.usf.fewa.services.TagTestService;

@RestController
@RequestMapping(value = "/tagtest")
public class TagTestController {
	
	@Autowired
	TagTestService tagTestService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/tagtest", produces = "application/json")
	public String home(@RequestParam(value = "tag", defaultValue = "null") String tag) {
		return tagTestService.returnService(tag);
	}

}
