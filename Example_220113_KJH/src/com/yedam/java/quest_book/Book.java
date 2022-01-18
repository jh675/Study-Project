package com.yedam.java.quest_book;

public class Book {
	private String bookName;
	private String bookWriter;
	private String bookContent;
	private int bookRental;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public int getBookRental() {
		return bookRental;
	}
	public void setBookRental(int bookRental) {
		this.bookRental = bookRental;
	}
	@Override
	public String toString() {
		return "Book [도서명=" + bookName + ", 저자=" + bookWriter + ", 도서내용=" + bookContent
				+ ", 대여여부=" + (bookRental == 1? "대여중" : "대여가능") + "]";
	}
	
}
