package com.yedam.java.quest01;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person = new Person();
		
		person.setName("김진환");
		person.setAddress("달서구");
		person.setSsn("999999-1234567");
		
		System.out.println("이름: " + person.getName());
		System.out.println("주소: " + person.getAddress());
		System.out.println("주민등록번호: " + person.getSsn());
	}

}
