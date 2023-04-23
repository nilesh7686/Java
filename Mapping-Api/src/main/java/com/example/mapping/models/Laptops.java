package com.example.mapping.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="laptop_details")
public class Laptops {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy" )
	private Date purchaseDate;
	
	private String colour;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student student;

	public Laptops() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptops(Long id, Date purchaseDate, String colour, Student student) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.colour = colour;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	
	
}
