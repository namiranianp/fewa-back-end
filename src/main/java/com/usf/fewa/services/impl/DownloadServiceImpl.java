package com.usf.fewa.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import java.nio.file.Path;
import java.io.File;
import org.springframework.core.io.InputStreamResource;
import java.io.FileInputStream;
import org.springframework.http.MediaType;

import com.usf.fewa.services.DownloadService;

public class DownloadServiceImpl implements DownloadService {

	private static Logger log = LogManager.getLogger("DownloadServiceImpl");

	@Override
	public ResponseEntity<InputStreamResource> download(String filename) throws IOException {
		File file = Path.of(filename).toFile();
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		return ResponseEntity
			.ok()
			.contentLength(file.length())
			.contentType(MediaType.APPLICATION_OCTET_STREAM)
			.body(resource);
	}
}
