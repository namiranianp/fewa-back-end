package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.MP4ContentService;

@RestController
@RequestMapping(value = "/mp4Content")
public class MP4ContentController {

	@Autowired
	MP4ContentService mp4ContentService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/mp4Content", produces = "video/mp4")
	public byte[] home() {
		
		try {
			
			return mp4ContentService.returnService();
			
		} catch (IOException ex) {
			
			// TODO
			System.out.println("MP4ContentController : Error Retrieving File Content");
			return null;
			
		}

	}

}