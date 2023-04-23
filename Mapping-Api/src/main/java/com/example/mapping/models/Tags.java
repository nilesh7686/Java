package com.example.mapping.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tags")
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tags")
	@JsonBackReference
	private Set<Posts> posts = new HashSet<>();

	public Tags() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tags(long id, String name, Set<Posts> posts) {
		super();
		this.id = id;
		this.name = name;
		this.posts = posts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Posts> getPosts() {
		return posts;
	}

	public void setPosts(Set<Posts> posts) {
		this.posts = posts;
	}
	
	

}
