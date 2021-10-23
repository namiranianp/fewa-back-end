package com.usf.fewa.services;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;

import java.io.IOException;

public interface DownloadService {
	public abstract ResponseEntity<InputStreamResource> download(String filename) throws IOException;
}