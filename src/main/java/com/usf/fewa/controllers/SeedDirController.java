package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.SeedDirService;

@RestController
@RequestMapping(value = "/seed")
public class SeedDirController {
	
	@Autowired
	SeedDirService seedDirService;

	@CrossOrigin(origins = "http://localhost")
	@PostMapping(path = "/")
	public void setSeed(@RequestParam(value = "dir", defaultValue = "/") String dir) {
		try {
			seedDirService.fileFetch(dir, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}