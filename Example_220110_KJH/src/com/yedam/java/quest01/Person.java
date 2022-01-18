package com.yedam.java.quest01;

public class Person {
	//필드
	private String name;
	private String address;
	private String ssn;
	
	//생성자
	
	public Person() {}
	public Person(String name, String address, String ssn) {
		this.name = name;
		this.address = address;
		this.ssn = ssn;
	}
	
	//메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
