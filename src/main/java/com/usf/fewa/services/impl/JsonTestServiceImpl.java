package com.usf.fewa.services.impl;

import com.usf.fewa.services.JsonTestService;

public class JsonTestServiceImpl implements JsonTestService {

	@Override
	public String returnService() {
		return "{\"files\":["
				+ "{\"name\":\"file.txt\", \"type\":\"file\"},"
				+ "{\"name\":\"file.pdf\", \"type\":\"file\"},"
				+ "{\"name\":\"file.jpeg\", \"type\":\"file\"},"
				+ "{\"name\":\"file.png\", \"type\":\"file\"},"
				+ "{\"name\":\"file.mp4\", \"type\":\"file\"},"
				+ "{\"name\":\"file\", \"type\":\"file\"},"
				+ "{\"name\":\"/folder\", \"type\":\"directory\"}"
				+ "]}";
	}
}
