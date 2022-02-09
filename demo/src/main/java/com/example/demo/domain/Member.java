package com.example.demo.domain;

import java.time.LocalDate;

public class Member {
	private String id;
	private String password;
	private String name;
	private String gender;
	private LocalDate birth;
	private String mail;
	private String phone;
	private String address;
	private String grade;
	private LocalDate reg;

	public Member(String id, String password, String name, String gender, LocalDate birth, String mail,
			String phone, String address, String grade) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public String getMail() {
		return mail;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
	
	public String getGrade() {
		return grade;
	}

	public LocalDate getReg() {
		return reg;
	}
	
	
}
