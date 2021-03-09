package com.usf.fewa.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.usf.fewa.entity.Owner;
import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;
import com.usf.fewa.services.SeedDirService;


public class SeedDirServiceImpl implements SeedDirService{
	
	@Autowired
	private ViewingObjectRepository repository;
	
	@Override
	/**
	 * Fetch all files from a path(String)
	 * @param path the root directory
	 * @param user the user using this service
	 * @throws IOException if an IO error occurs
	 */
	public void fileFetch(String path, Owner user) throws IOException{
		Path rootpath = Path.of(path);
		if (Files.isDirectory(rootpath)) {
			try (Stream<Path> paths = Files.walk(rootpath)) {
				List<ViewingObject> viewingObjects = new ArrayList<>();
				paths.forEach(p -> viewingObjects.add(new ViewingObject(p.getFileName().toString(), p.toAbsolutePath().toString(), user))); 
				repository.saveAll(viewingObjects);
			}
		} else {
			repository.save(new ViewingObject(rootpath.getFileName().toString(), rootpath.toAbsolutePath().toString(), user));
		}
	}

}
