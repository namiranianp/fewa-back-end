package com.usf.fewa.services.impl;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import com.usf.fewa.services.TXTContentService;

public class TXTContentServiceImpl implements TXTContentService {

	public @ResponseBody byte[] returnService() throws IOException {
		InputStream in = getClass().getResourceAsStream("/com/usf/fewa/files/test.txt");
		return IOUtils.toByteArray(in);
	}
	
}
