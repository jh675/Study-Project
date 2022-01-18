package com.yedam.java.quest_book;

import java.util.*;

public interface BookDAO {
	//전체 조회
	public List<Book> selectAll();
	
	//단건 조회
	public Book searchBook(String bookName);
	
	//등록
	public void insert(Book book);
	
	//수정
	public void update(Book book);
}