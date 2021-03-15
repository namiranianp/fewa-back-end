package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.PDFContentService;

@RestController
@RequestMapping(value = "/pdfContent")
public class PDFContentController {

	@Autowired
	PDFContentService pdfContentService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(value = "/pdfContent", produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] home() {
		
		try {
			
			return pdfContentService.returnService();
			
		} catch (IOException ex) {
			
			// TODO
			System.out.println("PDFContentController : Error Retrieving File Content");
			return null;
			
		}

	}

}