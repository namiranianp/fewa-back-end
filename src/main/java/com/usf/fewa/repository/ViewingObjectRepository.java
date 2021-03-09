package com.usf.fewa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.usf.fewa.entity.ViewingObject;

public interface ViewingObjectRepository extends JpaRepository<ViewingObject, Integer> {
	
	List<ViewingObject> findByPathStartingWith(String path);
	ViewingObject getByPath(@Param("path") String path);


}
