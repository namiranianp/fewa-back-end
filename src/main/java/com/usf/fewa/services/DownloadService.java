package com.usf.fewa.services;

import java.io.IOException;

public interface DownloadService {
	public void download(String filename, String destination) throws IOException;
}