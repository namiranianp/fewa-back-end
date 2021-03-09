package com.usf.fewa.services;

import com.usf.fewa.entity.Owner;

public interface TagService {
	public void addTag(String filePath, String tag, Owner owner);
	public void removeTag(String filename, String tag, Owner owner);
}
