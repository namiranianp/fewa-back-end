package com.usf.fewa.services.impl;

import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

		System.out.println(res);
		return res;
	}

	@Override
	public String getSuggestedFiles(String file) {
		System.out.println("getSuggestedFiles: " + file);

		Set<ViewingObject> voSet = new HashSet<>();

		ViewingObject vo = viewingObjectRepository.getByPath(file);

		// our super complicated algorithm

		for (Tag tag : vo.getTagSet()) {
			System.out.println("tag: " + tag.getName());
			for (ViewingObject v : tag.getViewingObjSet()) {
				System.out.println("vo: " + v.getPath());
				voSet.add(v);
			}
		}

		// we don't want to suggest the currently viewed file.
		voSet.remove(vo);

		return SeedDirServiceImpl.listToJsonWithPath(voSet);
	}

}
