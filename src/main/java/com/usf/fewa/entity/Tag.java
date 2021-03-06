package com.usf.fewa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;

	private String name;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;

	@ManyToMany(mappedBy = "tagSet")
	private Set<ViewingObject> viewingObjSet = new HashSet<>();

	public Tag() {

	}

	public Tag(String name, Owner owner) {
		this.name = name;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Set<ViewingObject> getViewingObjSet() {
		return viewingObjSet;
	}

	public void setViewingObjSet(Set<ViewingObject> viewingObjSet) {
		this.viewingObjSet = viewingObjSet;
	}

	@Override
	public String toString() {
		return "Tag [tid=" + tid + ", name=" + name + ", owner=" + owner + ", viewingObjSet=" + viewingObjSet + "]";
	}

}
