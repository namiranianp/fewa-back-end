package com.usf.fewa.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usf.fewa.services.DownloadService;

@RestController
@RequestMapping(value = "download", method = RequestMethod.GET)
public class DownloadFileController {

    private static Logger log = LogManager.getLogger("DownloadFileController");

	@Autowired
    ViewingObjectRepository repository;
	@Autowired
	DownloadService downloadService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/")
	public ResponseEntity<InputStreamResource> download(@RequestParam(value = "filePath") String filePath){
        log.info("path = " + filePath);
        ViewingObject vo = repository.getByPath(filePath);
        try {
            log.info("beginning download of path = " + vo.getName());
            return downloadService.download(filePath);
        } catch (Exception e) {
            log.info("could not download path = " + vo.getName());
            return null;
        }
	}

}