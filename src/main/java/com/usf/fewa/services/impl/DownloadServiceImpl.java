package com.usf.fewa.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOUtils;
import java.nio.file.Files;
import java.nio.file.Path;

import com.usf.fewa.services.DownloadService;

public class DownloadServiceImpl implements DownloadService {

	@Override
	public void download(String filename) throws IOException {
        //get destination for file
        String home = System.getProperty("user.home");
		String destination = home + "/Document/" + filename;
		//Download File
		try (InputStream inputStream = Files.newInputStream(Path.of(filename))) {
                  byte[] buffer = inputStream.readAllBytes();
                  OutputStream outStream = Files.newOutputStream(Path.of(destination));
                  outStream.write(buffer);

                  IOUtils.closeQuietly(outStream);
		}
	}

}
