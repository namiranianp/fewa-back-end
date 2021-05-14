package com.usf.fewa.services.impl;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;

import com.usf.fewa.entity.Owner;
import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;
import com.usf.fewa.services.SeedDirService;

public class SeedDirServiceImpl implements SeedDirService {

	@Autowired
	private ViewingObjectRepository repository;

	@Override
	/**
	 * Fetch all files from a path(String)
	 * 
	 * @param path the root directory
	 * @param user the user using this service
	 * @throws IOException if an IO error occurs
	 */
	public void fileFetch(String path, Owner user) throws IOException {
		Path rootpath = Path.of(path);
		if (!Files.exists(rootpath)) {
			return;
		}
		if (Files.isDirectory(rootpath)) {
			try (Stream<Path> paths = Files.walk(rootpath)) {
				List<ViewingObject> viewingObjects = new ArrayList<>();
				paths.filter(n -> repository.getByPath(n.toString()) == null).forEach(p -> viewingObjects
						.add(new ViewingObject(p.getFileName().toString(), p.toAbsolutePath().toString(), user)));
				repository.saveAll(viewingObjects);
			}
		} else {
			repository.save(
					new ViewingObject(rootpath.getFileName().toString(), rootpath.toAbsolutePath().toString(), user));
		}
	}

	/**
	 * List files and directories in json format such as ls command in the specific directory.
	 * 
	 * @param path the directory
	 * @return the json format stirng
	 * @throws IOException if an IO error occurs
	 */
	public String listFileToJson(String path) throws IOException {
		List<ViewingObject> list = repository.findByPathLike(
				path.replace(FileSystems.getDefault().getSeparator(), "\\" + FileSystems.getDefault().getSeparator())
						+ "%_");// should test for Unix system
		list.removeIf(e -> !e.isVisible());
		list.removeIf(vo -> vo.getPath().compareTo(path + FileSystems.getDefault().getSeparator() + vo.getName()) != 0);
		// C://desktop/d1/d2/test.txt   !=     C://desktop/d1 + / + test.txt
		return listToJson(list);
	}
	
	/**
	 * List files and directories in json format as below:
	 * 
	 * for example:
	 * {
	    	"files": [
		        {
		            "fullName": "1.jpg",
		            "type": "file",
		            "extension": "jpg"
		        },
		        {
		            "fullName": "desktop.ini",
		            "type": "file",
		            "extension": "ini"
		        }
		    ]
		}
		
		@param list the collection of files
		@return json format
	 */
	public static String listToJson(Collection<? extends ViewingObject> list) {
		String res = "{\"files\":[";
		Iterator<? extends ViewingObject> it = list.iterator();
		if (it.hasNext()) {
			res += getOnefileJson(it.next());
		}
		while (it.hasNext()) {
			res += ",";
			res += getOnefileJson(it.next());
		}
		res += "]}";
		return res;
	}

	/**
	 * Generate one file json including: name, file or directory, extension. 
	 * 
	 * @param vo the file object
	 * @return the json format string
	 */
	public static String getOnefileJson(ViewingObject vo) {
		String filename = vo.getName();
		String DIR = "file";
		if (Files.isDirectory(Path.of(vo.getPath()))) { // might modify to fileFetch
			DIR = "directory";
		}
		return "{\"fullName\":\"" + filename + "\", \"type\":\"" + DIR + "\",\"extension\":\""
				+ getExtensionByStringHandling(filename) + "\"}";
	}

	/**
	 * Get the file extension by filename.
	 * 
	 * @param filename the file name
	 * @return the extension
	 */
	private static String getExtensionByStringHandling(String filename) {
		int lastIndexOf = filename.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return ""; // empty extension
		}
		return filename.substring(lastIndexOf + 1);
	}

}
