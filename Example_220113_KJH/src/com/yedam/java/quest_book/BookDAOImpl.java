package com.yedam.java.quest_book;

import java.util.*;

import com.yedam.java.quest_common.DAO;

public class BookDAOImpl extends DAO implements BookDAO {
	private static BookDAO instance = new BookDAOImpl();
	private BookDAOImpl() {}
	public static BookDAO getInstance(){
		return instance;
	}
	
	@Override
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM book ORDER BY book_name";
			pst = conn.prepareStatement(select);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookName(rs.getString("book_name"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setBookContent(rs.getString("book_content"));
				book.setBookRental(rs.getInt("book_rental"));
				
				list.add(book);
			}
		} catch (Exception e) {
			System.out.println("전체 조회를 할 수 없습니다");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	@Override
	public Book searchBook(String bookName) {
		// TODO Auto-generated method stub
		Book book = null;
		try {
			connect();
			String select = "SELECT * FROM book WHERE book_name = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, bookName);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				book = new Book();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}

	@Override
	public void insert(Book book) {
		try {
			connect();
			String insert = "INSERT INTO book VALUES(?, ?, ?, ?)";
			pst = conn.prepareStatement(insert);
			pst.setString(1, book.getBookName());
			pst.setString(2, book.getBookWriter());
			pst.setString(3, book.getBookContent());
			pst.setInt(4, book.getBookRental());
			
			int result = pst.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상 등록되었습니다");
			}
		} catch (Exception e) {
			System.out.println("해당 도서를 등록할 수 없습니다");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void update(Book book) {
		try {
			connect();
			String update = "UPDATE book SET book_rental = ? WHERE book_name = ?";
			pst = conn.prepareStatement(update);
			pst.setInt(1, book.getBookRental());
			pst.setString(2, book.getBookName());
			
			int result = pst.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상 처리되었습니다");
			}
			
		} catch (Exception e) {
			System.out.println("해당 도서를 수정할 수 없습니다");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	

}
