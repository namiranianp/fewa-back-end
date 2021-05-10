package com.usf.fewa.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.usf.fewa.entity.ViewingObject;
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
		List<ViewingObject> list = viewingObjectRepository.findByNameContaining(fileName);
		list.removeIf(e -> !e.isVisible());
		return SeedDirServiceImpl.listToJson(list);
	}

	@Override
	public String SearchByTagName(String tagName) {
		Set<ViewingObject> set = tagRepository.getByName(tagName).getViewingObjSet();
		set.removeIf(e -> !e.isVisible());
		return SeedDirServiceImpl.listToJson(set);
	}

}
