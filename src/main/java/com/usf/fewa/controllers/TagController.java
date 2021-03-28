package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.TagService;

@RestController
@RequestMapping(value="tag")
public class TagController {
	
	@Autowired
	TagService tagService;

	@CrossOrigin(origins = "http://localhost")
	@PostMapping(path = "/add")
	public void addTag(@RequestParam(value="tagName") String tagName, @RequestParam(value="filePath") String filePath) {
		tagService.addTag(filePath, tagName, null);
	}
	
	@DeleteMapping(path = "/remove")
	public void removeTag(@RequestParam(value="tagName") String tagName, @RequestParam(value="filePath") String filePath) {
		tagService.removeTag(filePath, tagName, null);
	}

}
