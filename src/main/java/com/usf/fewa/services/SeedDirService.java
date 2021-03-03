package com.usf.fewa.services;

import java.io.IOException;

import com.usf.fewa.entity.Owner;

public interface SeedDirService {
	public void fileFetch(String path, Owner user) throws IOException;
}
