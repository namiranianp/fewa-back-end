package com.usf.fewa.services.impl;

import com.usf.fewa.services.JsonTestService;

public class JsonTestServiceImpl implements JsonTestService {

	@Override
	public String returnService(String msg) {
		return msg;
	}
}
