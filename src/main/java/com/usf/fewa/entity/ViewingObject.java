package com.usf.fewa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "viewingobject", uniqueConstraints = { @UniqueConstraint(columnNames = "path") })
public class ViewingObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vid;

	private String name;

	@Column(unique = true)
	private String path;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Owner owner;

	private boolean visible = true;

	@Type(type="org.hibernate.type.BinaryType") 
	private byte[] file;

	@ManyToMany(targetEntity = Tag.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "viewingobject_tag", joinColumns = @JoinColumn(name = "vid"), inverseJoinColumns = @JoinColumn(name = "tid"))
	private Set<Tag> tagSet = new HashSet<>();

	protected ViewingObject() {

	}

	public ViewingObject(String name, String path, Owner owner) {
		this.name = name;
		this.path = path;
		this.owner = owner;
	}

	public int getId() {
		return vid;
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

	public boolean isVisible() {
		return visible;
	}

	public void setInvisible() {
		this.visible = false;
	}

	public Set<Tag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}

	public void addTag(Tag tag) {
		tagSet.add(tag);
		tag.getViewingObjSet().add(this);
	}

	public void removeTag(Tag tag) {
		tagSet.remove(tag);
		tag.getViewingObjSet().remove(this);
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public byte[] getFile() {
		return this.file;
	}

	@Override
	public String toString() {
		return "ViewingObject [vid=" + vid + ", name=" + name + ", path=" + path + ", owner=" + owner + ", tagSet="
				+ tagSet + "]";
	}

}
