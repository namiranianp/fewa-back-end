package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.TXTContentService;

@RestController
@RequestMapping(value = "/txtContent")
public class TXTContentController {

	@Autowired
	TXTContentService txtContentService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/txtContent", produces = MediaType.TEXT_PLAIN_VALUE)
	public byte[] home() {
		
		try {
			
			return txtContentService.returnService();
			
		} catch (IOException ex) {
			
			// TODO
			System.out.println("TXTContentController : Error Retrieving File Content");
			return null;
			
		}

	}

}