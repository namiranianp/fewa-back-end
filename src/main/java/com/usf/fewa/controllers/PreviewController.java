package com.usf.fewa.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.services.PreviewService;

@RestController
@RequestMapping(value = "/file")
public class PreviewController {

	@Autowired
	PreviewService previewService;

	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(value = "txt", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody byte[] getTXT(@RequestParam(value = "file") String file) throws IOException {
		return previewService.preview(file);
	}

	@RequestMapping(value = "pdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
	public @ResponseBody byte[] getPDF(@RequestParam(value = "file") String file) throws IOException {
		return previewService.preview(file);
	}

	@RequestMapping(value = "jpeg", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getJPEG(@RequestParam(value = "file") String file) throws IOException {
		return previewService.preview(file);
	}

	@RequestMapping(value = "png", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getPNG(@RequestParam(value = "file") String file) throws IOException {
		return previewService.preview(file);
	}

	@RequestMapping(value = "mp4", method = RequestMethod.GET, produces = "video/mp4")
	public @ResponseBody byte[] getMP4(@RequestParam(value = "file") String file) throws IOException {
		return previewService.preview(file);
	}
}
