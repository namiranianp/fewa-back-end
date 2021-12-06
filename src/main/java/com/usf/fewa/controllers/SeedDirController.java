package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.SeedDirService;

@RestController
@RequestMapping(value = "/path")
public class SeedDirController {

	@Autowired
	SeedDirService seedDirService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/setseed", produces = "application/json")
	public String setSeed(@RequestParam(value = "dir", defaultValue = "/") String dir) {
		try {
			seedDirService.fileFetch(dir, null);
			return seedDirService.listFileToJson(dir);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@GetMapping(path = "/getfiles", produces = "application/json")
	public String getDirFiles(@RequestParam(value = "dir") String dir) {
		try {
			return seedDirService.listFileToJson(dir);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/database", produces = "application/json")
	public String getDatabase(@RequestParam(value = "dir", defaultValue = "/") String dir) {
		try {
			return seedDirService.DatabaseToJson(null);
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

}
