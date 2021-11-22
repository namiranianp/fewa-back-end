package com.usf.fewa.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.usf.fewa.services.UploadService;


@CrossOrigin(origins = "http://localhost")
@RestController
public class UploadFileController {
    private static Logger log = LogManager.getLogger("DownloadFileController");

    @Autowired
    UploadService uploadService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity uploadFile(@RequestBody MultipartFile file){
        log.info("Part1");
        return uploadService.upload(file);
    }
}
