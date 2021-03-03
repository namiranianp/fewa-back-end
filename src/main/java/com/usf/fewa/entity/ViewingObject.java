package com.usf.fewa.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="viewingobject")
public class ViewingObject {

	@Id 
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int vid;
	
	private String name;
	
	private String path;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Owner owner;
	
	@ManyToMany(targetEntity=Tag.class,cascade=CascadeType.PERSIST)
	private Set<Tag> tagSet;
	
	public ViewingObject() {
		
	}
	public ViewingObject(String name, String path, Owner owner) {
		this.name = name;
		this.path = path;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Set<Tag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}

}
