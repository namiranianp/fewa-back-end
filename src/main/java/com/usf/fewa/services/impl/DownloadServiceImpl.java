package com.usf.fewa.services.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.usf.fewa.services.DownloadService;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class DownloadServiceImpl implements DownloadService {

	private static Logger log = LogManager.getLogger("DownloadFileController");
	
	@Override
	public void download(String filename) throws IOException {
		//get destination for file
		log.info("creating home directory from = " + filename);
        String home = System.getProperty("user.home");
		String destination = home + "/Document/" + filename;
		log.info("done = " + home + "/Document/" + filename);
		//Download File
		log.info("beginning download = " + home + "/Document/" + filename);
		try (InputStream inputStream = Files.newInputStream(Path.of(filename))) {
			byte[] buffer = inputStream.readAllBytes();
			OutputStream outStream = Files.newOutputStream(Path.of(destination));
			outStream.write(buffer);

			IOUtils.closeQuietly(outStream);
				  
			log.info("done downloading");
		}
	}

}
