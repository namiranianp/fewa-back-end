package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.entity.Owner;
import com.usf.fewa.services.SeedDirService;

@RestController
@RequestMapping(value = "/seed")
public class SeedDirController {
	
	@Autowired
	SeedDirService seedDirService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/seed")
	public void setSeed(@RequestParam(value = "dir", defaultValue = "/") String dir) {
		try {
			seedDirService.fileFetch(dir, new Owner("login", "pssword"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
