package com.usf.fewa.services.impl;

import com.usf.fewa.services.JsonTestService;

public class JsonTestServiceImpl implements JsonTestService {

	@Override
	public String returnService() {
		return "{\r\n"
				+ "\t{\"name\":\"file.txt\", \"type\": \"file\"},\r\n"
				+ "\t{\"name\":\"file.pdf\", \"type\": \"file\"},\r\n"
				+ "\t{\"name\":\"file.mp3\", \"type\": \"file\"},\r\n"
				+ "\t{\"name\":\"/folder\", \"type\": \"directory\"}\r\n"
				+ "}";
	}
}
