package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.SearchService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/name", produces = "application/json")
	public String searchByName(@RequestParam(value = "file") String fileName) {
		return searchService.SearchByFileName(fileName);
	}
	
	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/tag", produces = "application/json")
	public String searchByTag(@RequestParam(value = "tag") String tagName) {
		return searchService.SearchByTagName(tagName);
	}

}
