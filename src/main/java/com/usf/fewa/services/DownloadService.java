package com.usf.fewa.services;

import java.io.IOException;

public interface DownloadService {
	public abstract void download(String filename) throws IOException;
}