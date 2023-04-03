package com.labinsights.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Transient;

 
@Entity
@Table(name = "app")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	
	@Column(name = "description")
	private String description;

	
	@Column(name = "regtime")
	@Transient
	private String regtime;
	@Column(name="status")
	
	private String status;
	
	@Column(name = "userid")
	private String userid;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getuserid() {
		return userid;
	}

	public void setuserid(String userid) {
		this.userid = userid;
	}

	public Appointment(int id, String name, String email, String date, String time, String description, String regtime,
			String status, String userid) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
		this.time = time;
		this.description = description;
		this.regtime = regtime;
		this.status = status;
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", name=" + name + ", email=" + email + ", date=" + date + ", time=" + time
				+ ", description=" + description + ", regtime=" + regtime + ", status=" + status + ", userid=" + userid
				+ "]";
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
}