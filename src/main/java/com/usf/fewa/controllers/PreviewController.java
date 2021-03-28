package com.usf.fewa.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/file")
public class PreviewController {

	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(value = "preview", method = RequestMethod.GET)
	public void preview(HttpServletResponse response, @RequestParam(value = "file") String file) throws IOException {

		Path path = Path.of(file);
		if (!Files.isReadable(path)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource Not Found");
			return;
		}

		String mimeType = URLConnection.guessContentTypeFromName(path.getFileName().toString());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		
		System.out.println(mimeType);

		response.setContentType(mimeType);
		response.setHeader("Content-disposition",
				String.format("attachment; filename=\"%s\"", URLEncoder.encode(path.getFileName().toString(), "UTF-8")));
		response.setContentLength((int) Files.size(path));

		try (InputStream inputStream = Files.newInputStream(path)) {
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		}
	}

}
