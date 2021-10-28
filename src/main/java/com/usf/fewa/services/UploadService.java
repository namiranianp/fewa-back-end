package com.usf.fewa.services;
import org.springframework.http.ResponseEntity;


public interface UploadService {
    public abstract ResponseEntity upload(String filePath, String uploadDirectory);
}
