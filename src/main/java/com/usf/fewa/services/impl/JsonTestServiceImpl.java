package com.usf.fewa.services.impl;

import com.usf.fewa.services.JsonTestService;

public class JsonTestServiceImpl implements JsonTestService {

	@Override
	public String returnService() {
		return "{\"files\":["
				+ "{\"name\":\"file\", \"type\":\"file\", \"extension\":\"txt\"},"
				+ "{\"name\":\"file\", \"type\":\"file\", \"extension\":\"pdf\"},"
				+ "{\"name\":\"file\", \"type\":\"file\", \"extension\":\"jpeg\"},"
				+ "{\"name\":\"file\", \"type\":\"file\", \"extension\":\"png\"},"
				+ "{\"name\":\"file\", \"type\":\"file\", \"extension\":\"mp4\"},"
				+ "{\"name\":\"file\", \"type\":\"file\", \"extension\":\"\"},"
				+ "{\"name\":\"file\", \"type\":\"directory\", \"extension\":\"\"}"
				+ "]}";
	}
}
