package com.usf.fewa.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import com.usf.fewa.services.PreviewService;

public class PreviewServiceImpl implements PreviewService {

	@Override
	public byte[] preview(String filename) throws IOException {
		try (InputStream inputStream = Files.newInputStream(Path.of(filename))) {
			return inputStream.readAllBytes();
		}
	}

}
