package com.usf.fewa.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import java.nio.file.Path;
import java.io.File;
import org.springframework.core.io.InputStreamResource;
import java.io.FileInputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.usf.fewa.services.DownloadService;

public class DownloadServiceImpl implements DownloadService {

	private static Logger log = LogManager.getLogger("DownloadServiceImpl");

	@Override
	public ResponseEntity download(String filePath) throws IOException {
		File file = Path.of(filePath).toFile();
		String fileName = file.getName();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
				.body(file);
	}
}
