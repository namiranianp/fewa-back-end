package com.usf.fewa.services.impl;

import com.usf.fewa.services.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public String returnService(String msg) {
		return msg;
	}
}
