package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.repository.ViewingObjectRepository;

@RestController
@RequestMapping(value = "delete")
public class DeleteFileController {

	@Autowired
	ViewingObjectRepository repository;

	@CrossOrigin(origins = "http://localhost")
	@PostMapping(path = "/")
	public void delete(@RequestParam(value = "filePath") String filePath) {
		repository.getByPath(filePath).setInvisible();
	}

}
