package com.usf.fewa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.usf.fewa.entity.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {
	Tag getByName(@Param("name") String name);
	


}
