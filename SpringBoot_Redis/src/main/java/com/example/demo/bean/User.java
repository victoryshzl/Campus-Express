package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="stu")
public class User {
	String uid;
	String username;
	String password;
	public User() {}
	public void setUid(String s) {
		uid=s;
	}
	@Id
	@GenericGenerator(name="session_info_uuid_gen",strategy="assigned")
	@GeneratedValue(generator="session_info_uuid_gen")
	@Column(name="uid")
	public String getUid() {
		return uid;
	}
	
	public void setUsername(String s) {
		username=s;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String s) {
		password=s;
	}
	public String getPassword() {
		return password;
	}

	public User(String uid,String username,String password){
		super();
		this.uid=uid;
		this.username=username;
		this.password=password;
	}
	

}
