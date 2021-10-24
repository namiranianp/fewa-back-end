package com.usf.fewa.services;
import org.springframework.http.ResponseEntity;
import java.io.File;

import java.io.IOException;

public interface DownloadService {
	public abstract ResponseEntity<File> download(String filePath) throws IOException;
}