package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.TagService;

@RestController
@RequestMapping(value = "tag")
public class TagController {

	@Autowired
	TagService tagService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/add")
	public void addTag(@RequestParam(value = "tagName") String tagName,
					   @RequestParam(value = "filePath") String filePath) {
		tagService.addTag(filePath, tagName, null);
	}

	@GetMapping(path = "/remove")
	public void removeTag(@RequestParam(value = "tagName") String tagName,
						  @RequestParam(value = "filePath") String filePath) {
		tagService.removeTag(filePath, tagName, null);
	}
	@GetMapping(path = "/display", produces = "application/json")
	public String displayTag(@RequestParam(value = "filePath") String filePath) {
		tagService.getSuggestedFiles(filePath);
		return tagService.displayTag(filePath);
	}

	@GetMapping(path = "/suggest", produces = "application/json")
	public String suggestedFiles(@RequestParam(value = "filePath") String filePath) {
		return tagService.getSuggestedFiles(filePath);
	}
}
