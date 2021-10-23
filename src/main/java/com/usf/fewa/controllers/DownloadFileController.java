package com.usf.fewa.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;

import com.usf.fewa.services.PreviewService;

@RestController
@RequestMapping(value = "download")
public class DownloadFileController {

    private static Logger log = LogManager.getLogger("DownloadFileController");

	@Autowired
    ViewingObjectRepository repository;
	@Autowired
	PreviewService previewService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/")
	public ResponseEntity<byte[]> download(@RequestParam(value = "filePath") String filePath){
        ViewingObject vo = repository.getByPath(filePath);
        log.info("path = " + filePath);
        //Download file
        String filename = vo.getName();
        try {
            byte[] fileBytes = previewService.preview(filename);
            return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+filename)
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(fileBytes.length)
                .body(fileBytes);
        } catch (Exception e) {
            System.out.println("Error downloading file.");
            return null;
        }
	}

}