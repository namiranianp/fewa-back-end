package com.usf.fewa.services.impl;

import java.util.List;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.TagRepository;
import com.usf.fewa.repository.ViewingObjectRepository;
import com.usf.fewa.services.SearchService;

public class SearchServiceImpl implements SearchService {

	private ViewingObjectRepository viewingObjectRepository;

	//private TagRepository tagRepository;

	public SearchServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<ViewingObject> SearchByFileName(String fileName) {
		return viewingObjectRepository.findByNameContaining(fileName);
	}

	public List<ViewingObject> SearchByTagName(String tagName) {
		return viewingObjectRepository.findByNameContaining(tagName); //TODO
	}

}
