package com.example.mapping.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Posts { 
	
	 @Id
	@jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long id;
	 
	 @Column(name = "title")
	    private String title;

	    @Column(name = "description")
	    private String description;

	    @Column(name = "content")
	    private String content;
  

	    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JoinTable(name = "post_tags",
	        joinColumns = {
	            @JoinColumn(name = "post_id")
	        },
	        inverseJoinColumns = {
	            @JoinColumn(name = "tag_id")
	        })
	    @JsonManagedReference
	    private Set< Tags > tags = new HashSet<>();


		public Posts() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Posts(long id, String title, String description, String content, Set<Tags> tags) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.content = content;
			this.tags = tags;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}


		public Set<Tags> getTags() {
			return tags;
		}


		public void setTags(Set<Tags> tags) {
			this.tags = tags;
		}
	    
	    

}
