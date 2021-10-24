package com.usf.fewa.services.impl;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import java.nio.file.Path;
import java.io.File;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.usf.fewa.services.DownloadService;

public class DownloadServiceImpl implements DownloadService {

	@Override
	public ResponseEntity<File> download(String filePath) throws IOException {
		File file = Path.of(filePath).toFile();
		String fileName = file.getName();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(file);
	}
}
