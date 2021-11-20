package com.usf.fewa.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.usf.fewa.services.UploadService;

@RestController
@RequestMapping(value = "upload", method = RequestMethod.POST)
public class UploadFileController {

    @Autowired
    UploadService uploadService;

	@CrossOrigin(origins = "http://localhost")
    @GetMapping(path = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity uploadFile(MultipartFile file){
        return uploadService.upload(file);
    }
}
