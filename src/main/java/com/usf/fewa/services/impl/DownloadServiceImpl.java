package com.usf.fewa.services.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;
import com.usf.fewa.services.DownloadService;

public class DownloadServiceImpl implements DownloadService {
    private static Logger log = LogManager.getLogger("UploadFileController");

    @Autowired
    ViewingObjectRepository repository;

	@Override
	public byte[] download(String filePath) throws IOException {
		filePath = filePath.replaceFirst("files/database/", "");
		ViewingObject file = repository.getByPath(filePath);
		return file.getFile();
	}
}
