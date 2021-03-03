package com.usf.fewa.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.usf.fewa.entity.Owner;
import com.usf.fewa.entity.ViewingObject;
import com.usf.fewa.services.SeedDirService;


public class SeedDirServiceimpl implements SeedDirService{
	@Override
	/**
	 * Fetch all files from a path(String)
	 * @param path the root directory
	 * @param user the user using this service
	 * @throws IOException if an IO error occurs
	 */
	public void fileFetch(String path, Owner user) throws IOException{
		Path rootpath = Path.of(path);
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("EntityFactory");
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		if (Files.isDirectory(rootpath)) {
			try (Stream<Path> paths = Files.walk(rootpath)) {
				paths.forEach(p -> entitymanager.persist(new ViewingObject(p.getFileName().toString(), p.toAbsolutePath().toString(), user))); 
			}
		} else {
			entitymanager.persist(new ViewingObject(rootpath.getFileName().toString(), rootpath.toAbsolutePath().toString(), user));
		}
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

}
