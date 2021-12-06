package com.usf.fewa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.repository.ViewingObjectRepository;

import java.io.File;

@RestController
@RequestMapping(value = "delete")
public class DeleteFileController {

	@Autowired
	ViewingObjectRepository repository;

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/hide")
	public void hide(@RequestParam(value = "filePath") String filePath) {
		ViewingObject vo = repository.getByPath(filePath);
		vo.setInvisible();
		repository.save(vo);
	}

	@CrossOrigin(origins = "http://localhost")
	@GetMapping(path = "/delete")
	public void delete(@RequestParam(value = "filePath") String filePath) {
		ViewingObject vo = repository.getByPath(filePath);
		File file = new File(vo.getPath());

		if(file.delete())
		{
			System.out.println(file.getName() + " deleted");
		}
		else
		{
			System.out.println(file.getName() + " failed");
		}

		repository.delete(vo);
	}
}
