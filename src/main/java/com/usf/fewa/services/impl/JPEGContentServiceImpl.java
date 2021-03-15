package com.usf.fewa.services.impl;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import com.usf.fewa.services.JPEGContentService;

public class JPEGContentServiceImpl implements JPEGContentService {

	public @ResponseBody byte[] returnService() throws IOException {
		InputStream in = getClass().getResourceAsStream("/com/usf/fewa/files/test.jpg");
		return IOUtils.toByteArray(in);
	}
	
}
