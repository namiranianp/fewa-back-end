package com.usf.fewa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.usf.fewa.entity.ViewingObject;

public interface ViewingObjectRepository extends CrudRepository<ViewingObject, Integer> {
	
	List<ViewingObject> findByPathStartingWith(String path);


}
