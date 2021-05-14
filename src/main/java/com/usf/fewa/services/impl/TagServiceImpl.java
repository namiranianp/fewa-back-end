package com.usf.fewa.services.impl;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import com.usf.fewa.entity.Owner;
import com.usf.fewa.entity.Tag;
import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.TagRepository;
import com.usf.fewa.repository.ViewingObjectRepository;
import com.usf.fewa.services.TagService;

public class TagServiceImpl implements TagService {

	@Autowired
	private ViewingObjectRepository viewingObjectRepository;

	@Autowired
	private TagRepository tagRepository;

	@Override
	public void addTag(String filePath, String tagName, Owner owner) {
		ViewingObject vo = viewingObjectRepository.getByPath(filePath);

		if (vo == null) {
			// TODO: exception handle
		}
		Tag tag = tagRepository.getByName(tagName);
		if (tag == null) {
			tag = new Tag(tagName, owner);
		}
		vo.addTag(tag);
		tagRepository.save(tag);
		viewingObjectRepository.save(vo);

	}

	@Override
	public void removeTag(String filePath, String tagName, Owner owner) {
		ViewingObject vo = viewingObjectRepository.getByPath(filePath);

		if (vo == null) {
			// TODO: exception handle
		}
		Tag tag = tagRepository.getByName(tagName);
		vo.removeTag(tag);
		tagRepository.save(tag);
		viewingObjectRepository.save(vo);

	}
	@Override
	public String displayTag(String filePath) {
		ViewingObject vo = viewingObjectRepository.getByPath(filePath);
		
		String res = "{\"tags\":[";
		Iterator<Tag> it = vo.getTagSet().iterator();
		if (it.hasNext()) {
			res += "\"" + it.next().getName() + "\"";
		}
		while (it.hasNext()) {
			res += ",";
			res += "\"" + it.next().getName() + "\"";
		}
		res += "]}";
		return res;
	}
	

}
