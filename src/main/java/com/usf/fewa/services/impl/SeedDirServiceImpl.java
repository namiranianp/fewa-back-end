package com.usf.fewa.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
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
		if (repository.getByPath(path) != null) {
			System.out.println("find same");
			return;
		}
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
	public String listFileToJson(String path) throws IOException {
		System.out.println(path);
		List<ViewingObject> list = repository.findByPathLike(path.replace("\\", "\\\\") + "%_");
		String res = "{\"files\":[";
		Iterator<ViewingObject> it = list.iterator();
		res += getOnefileJson(it.next());
		while (it.hasNext()) {
			res += ",";
			res += getOnefileJson(it.next());
		}
		res += "]}";
		return res;
				
				
	}
	private String getOnefileJson(ViewingObject vo) {
		String filename = vo.getName();
		String DIR = "file";
		if (Files.isDirectory(Path.of(vo.getPath()))) {  //might modify to fileFetch
			DIR = "directory";
		}
		return "{\"fullName\":\"" + filename + "\", \"type\":\"" + DIR + "\",\"extension\":\"" + getExtensionByStringHandling(filename) + "\"}";
	}
	private String getExtensionByStringHandling(String filename) {
		int lastIndexOf = filename.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return filename.substring(lastIndexOf + 1);
	}

}
