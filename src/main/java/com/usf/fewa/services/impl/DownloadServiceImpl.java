package com.usf.fewa.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.usf.fewa.services.DownloadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class DownloadServiceImpl implements DownloadService {

	private static Logger log = LogManager.getLogger("DownloadServiceImpl");

	@Override
	public void download(String filename) throws IOException {
        //get destination for file
		log.info("path = " + filename);
        String home = System.getProperty("user.home");
		//TODO: should it be Documents??
		String destination = home + "/Document/" + filename;
		//Download File
		try (InputStream inputStream = Files.newInputStream(Path.of(filename))) {
			log.info("input stream created for path = " + filename);
			byte[] buffer = inputStream.readAllBytes();
			log.info("buffer created");
			//TODO: outstream not being created, catching ioexception
			OutputStream outStream = Files.newOutputStream(Path.of(destination));
			log.info("output stream created for destination = " + destination);
			outStream.write(buffer);

			IOUtils.closeQuietly(outStream);
		}
	}

}
