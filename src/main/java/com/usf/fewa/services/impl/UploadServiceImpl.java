package com.usf.fewa.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.io.File;

import com.usf.fewa.entity.Owner;
import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;

import com.usf.fewa.services.UploadService;

public class UploadServiceImpl implements UploadService {
    private static Logger log = LogManager.getLogger("UploadServiceImpl");

    @Autowired
    ViewingObjectRepository repository;

    @Override
    public ResponseEntity upload(String filePath, String uploadDirectory){
        File file = Path.of(filePath).toFile();
        log.info("path = " + filePath);
        String fileName = file.getName();
        log.info("file = " + fileName);
        ViewingObject vo = new ViewingObject(fileName, filePath, new Owner());
        
        repository.save(vo);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(uploadDirectory)
                .path(vo.getId() + "_" + fileName).path("/db")
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }
}
