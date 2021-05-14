package com.usf.fewa.services;

import java.io.IOException;

public interface PreviewService {
	public byte[] preview(String filename) throws IOException;
}
