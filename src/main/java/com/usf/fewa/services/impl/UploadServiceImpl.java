package com.usf.fewa.services.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.entity.Owner;
import com.usf.fewa.repository.ViewingObjectRepository;

import com.usf.fewa.services.UploadService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UploadServiceImpl implements UploadService {
    private static Logger log = LogManager.getLogger("DownloadFileController");

    @Autowired
    ViewingObjectRepository repository;

    @Override
    public ResponseEntity upload(MultipartFile file){
        String filePath = file.getOriginalFilename();
        String fileName = StringUtils.cleanPath(filePath);
        ViewingObject vo = new ViewingObject(fileName, file.getOriginalFilename(), new Owner("random", "random"));
        try {
            vo.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        repository.save(vo);
        
        String fileUploadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/?filePath=")
                .path(filePath)
                .toUriString();
        return ResponseEntity.ok(fileUploadUri);
    }
}
