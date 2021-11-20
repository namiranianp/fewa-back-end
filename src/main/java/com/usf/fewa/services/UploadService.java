package com.usf.fewa.services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;


public interface UploadService {
    public abstract ResponseEntity upload(MultipartFile file);
}
