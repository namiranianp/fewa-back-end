package com.usf.fewa.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.usf.fewa.services.UploadService;

@RestController
@RequestMapping(value = "upload", method = RequestMethod.GET)
public class UploadFileController {

    @Autowired
    UploadService uploadService;

//	@CrossOrigin(origins = "http://localhost")
//	@GetMapping(path = "/")
//	public ResponseEntity uploadAll(@RequestParam(value = "filePath") String filePaths, @RequestParam(value = "uploadDirectory") String uploadDirectory){
//        List<String> fileDownloadUrls = new ArrayList<>();
//        Arrays.asList(filePaths)
//                .stream()
//                .forEach(filePath -> uploadService.upload(filePath, uploadDirectory));
//        return ResponseEntity.ok(fileDownloadUrls);
//    }

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/")
	public ResponseEntity uploadFile(@RequestParam(value = "filePath") String filePath, @RequestParam(value = "uploadDirectory") String uploadDirectory){
        return uploadService.upload(filePath, uploadDirectory);
    }
}
