package com.naver;

import java.io.Serializable;

public class LoginDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private int age;
	
	public LoginDTO() {} 

	public LoginDTO(String id, int age) {
		super();
		this.id = id;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}		
}
