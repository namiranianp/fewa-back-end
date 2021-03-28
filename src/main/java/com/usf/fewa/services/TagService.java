package com.usf.fewa.services;

import com.usf.fewa.entity.Owner;

public interface TagService {
	public void addTag(String filePath, String tagName, Owner owner);
	public void removeTag(String filePath, String tagName, Owner owner);
}
