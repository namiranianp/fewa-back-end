package com.usf.fewa.services.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Path;
import java.io.File;

import com.usf.fewa.repository.ViewingObjectRepository;

import com.usf.fewa.services.UploadService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

public class UploadServiceImpl implements UploadService {
    @Autowired
    ViewingObjectRepository repository;

    @Override
    public ResponseEntity upload(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName).path("/db")
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }
}
