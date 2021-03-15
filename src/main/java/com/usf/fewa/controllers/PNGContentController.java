package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.PNGContentService;

@RestController
@RequestMapping(value = "/pngContent")
public class PNGContentController {

	@Autowired
	PNGContentService pngContentService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/pngContent", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] home() {
		
		try {
			
			return pngContentService.returnService();
			
		} catch (IOException ex) {
			
			// TODO
			System.out.println("PNGContentController : Error Retrieving File Content");
			return null;
			
		}

	}

}