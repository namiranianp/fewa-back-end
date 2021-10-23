package com.usf.fewa.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;

import com.usf.fewa.services.DownloadService;

import java.io.IOException;

@RestController
@RequestMapping(value = "download")
public class DownloadFileController {

    private static Logger log = LogManager.getLogger("DownloadFileController");

	@Autowired
    ViewingObjectRepository repository;
    @Autowired
	DownloadService downloadService;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/")
	public void download(@RequestParam(value = "filePath") String filePath){
        ViewingObject vo = repository.getByPath(filePath);
        log.info("path = " + filePath);
        if(vo.isVisible()) {
            //Download file
            try {
                log.info("beginning download path = " + filePath);
                downloadService.download(filePath);
                log.info("download path success= " + filePath);
            }catch(IOException ioe){
                System.out.println("could not download file");
            }
        } else {
            System.out.println("could not access file to download");
        }
	}

}