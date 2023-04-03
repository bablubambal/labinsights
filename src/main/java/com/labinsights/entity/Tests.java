package com.labinsights.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.annotation.Transient;

 
@Entity
@Table(name = "tests")
public class Tests {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
//	@Email(message = "Please provide a valid e-mail")
//	@NotEmpty(message = "Please provide an e-mail")
	private String name;
	
	@Column(name = "description")
	@Transient
	private String description;

	public Tests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tests(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Tests [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	

}