package com.usf.fewa.services.impl;

import com.usf.fewa.services.JsonTestService;

public class JsonTestServiceImpl implements JsonTestService {

	@Override
	public String returnService() {
		return "{\"files\":["
				+ "{\"fullName\":\"file.txt\", \"type\":\"file\", \"extension\":\"txt\"},"
				+ "{\"fullName\":\"file.pdf\", \"type\":\"file\", \"extension\":\"pdf\"},"
				+ "{\"fullName\":\"file.jpeg\", \"type\":\"file\", \"extension\":\"jpeg\"},"
				+ "{\"fullName\":\"file.png\", \"type\":\"file\", \"extension\":\"png\"},"
				+ "{\"fullName\":\"file.mp4\", \"type\":\"file\", \"extension\":\"mp4\"},"
				+ "{\"fullName\":\"file\", \"type\":\"file\", \"extension\":\"\"},"
				+ "{\"fullName\":\"/folder\", \"type\":\"directory\", \"extension\":\"\"}"
				+ "]}";
	}
}
