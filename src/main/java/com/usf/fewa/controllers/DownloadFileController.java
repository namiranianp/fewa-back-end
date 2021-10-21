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
import com.usf.fewa.services.PreviewService;

@RestController
@RequestMapping(value = "download")
public class DownloadFileController {

	@Autowired
    ViewingObjectRepository repository;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/")
	public void download(@RequestParam(value = "filePath") String filePath) {
        ViewingObject vo = repository.getByPath(filePath);
        if(vo.isVisible()) {
            //Download file
            downloadService.download(filePath);
        } else {
            //TODO file not found error
        }
	}

}