package com.usf.fewa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.usf.fewa.repository.TagRepository;
import com.usf.fewa.repository.ViewingObjectRepository;
import com.usf.fewa.services.SearchService;

public class SearchServiceImpl implements SearchService {

	@Autowired
	private ViewingObjectRepository viewingObjectRepository;

	@Autowired
	private TagRepository tagRepository;


	@Override
	public String SearchByFileName(String fileName) {
		return SeedDirServiceImpl.listToJson(viewingObjectRepository.findByNameContaining(fileName));
	}

	@Override
	public String SearchByTagName(String tagName) {
		return SeedDirServiceImpl.listToJson(tagRepository.getByName(tagName).getViewingObjSet());
	}

}
