package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.JPEGContentService;

@RestController
@RequestMapping(value = "/jpegContent")
public class JPEGContentController {

	@Autowired
	JPEGContentService jPEGContentService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/jpegContent", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] home() {
		
		try {
			
			return jPEGContentService.returnService();
			
		} catch (IOException ex) {
			
			// TODO
			System.out.println("JPEGContentController : Error Retrieving File Content");
			return null;
			
		}

	}

}