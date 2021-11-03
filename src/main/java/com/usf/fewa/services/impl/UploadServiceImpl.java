package com.usf.fewa.services.impl;

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
    @Autowired
    ViewingObjectRepository repository;

    @Override
    public ResponseEntity upload(String filePath, String uploadDirectory){
        File file = Path.of(filePath).toFile();
        String fileName = file.getName();
        ViewingObject vo = new ViewingObject(fileName, filePath, new Owner());
        
        repository.save(vo);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(uploadDirectory)
                .path(vo.getId() + "_" + fileName).path("/db")
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }
}
