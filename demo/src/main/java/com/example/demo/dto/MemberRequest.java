package com.example.demo.dto;

public class MemberRequest {
	private String id;
	private String password;
	private String name;
	private String gender;
	private int year;
	private int month;
	private int day;
	private String emailId;
	private String emailAddress;
	private String phone;
	private String address;

	public MemberRequest(String id, String password, String name, String gender, int year, int month, int day,
			String emailId, String emailAddress, String phone, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.year = year;
		this.month = month;
		this.day = day;
		this.emailId = emailId;
		this.emailAddress = emailAddress;
		this.phone = phone;
		this.address = address;
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

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
}