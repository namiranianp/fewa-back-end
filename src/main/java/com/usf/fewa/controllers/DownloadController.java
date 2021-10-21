package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;

import com.usf.fewa.services.DownloadService;

@RestController
@RequestMapping(value = "download")
public class DownloadFileController {

	@Autowired
    ViewingObjectRepository repository;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/download")
	public void download(@RequestParam(value = "filePath") String filePath) {
        ViewingObject vo = repository.getByPath(filePath);
        //TODO get destination somehow
        String home = System.getProperty("user.home");
        String destination = home + "/Document/" + vo.getName();
        if(vo.isVisible()) {
            //TODO Download file
            //TODO might have to download using frontend??
            downloadService.download(filePath, destination);
        } else {
            //TODO file not found error
        }
	}

}