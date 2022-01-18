package com.yedam.java.quest_app;

import java.util.*;

import com.yedam.java.quest_book.*;

public class Library {
	private Scanner sc = new Scanner(System.in);
	private BookDAO dao = BookDAOImpl.getInstance();
	public Library() {
		while(true) {
			//메뉴 출력
			menuPrint();
			
			//메뉴 선택
			int menuNo = menuSelect();
			
			//메뉴별 실행
			if(menuNo == 1) {
				//전체 조회
				allBooksList();
			} else if(menuNo == 2) {
				//단건 조회
				searchBookInfo();
			} else if(menuNo == 3) {
				//내용 검색
				searchBookContent();
			} else if(menuNo == 4) {
				//대여 조회
				selectRentalBookList();
			} else if(menuNo == 5) {
				//대여
				rentalBook();
			} else if(menuNo == 6) {
				//반납
				returnBook();
			} else if(menuNo == 7) {
				//등록
				insertBookInfo();
			} else if(menuNo == 9) {
				end();
			}
		}
	}
	private void menuPrint() {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------------------------");
		System.out.println("1.전체 조회 | 2.단건 조회 | 3.내용 검색 | 4.대여 조회 | 5.도서 대여 | 6.도서 반납 | 7.도서 등록|9.종료");
		System.out.println("------------------------------------------------------------------");
		System.out.print("선택> ");
	}
	private int menuSelect() {
		// TODO Auto-generated method stub
		int menuNo = 0;
		try {
			menuNo  = sc.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다");
		}
		return menuNo;
	}
	private void allBooksList() {
		List<Book> list = dao.selectAll();
		for(Book book : list) {
			System.out.println(book);
		}
	}
	private void searchBookInfo() {
		//도서 제목 입력
		String bookName = inputBookName();
		Book book = dao.searchBook(bookName);
		
		if(book != null) {
			System.out.println(book);
		} else {
			System.out.println("해당 도서의 정보가 존재하지 않습니다.");
		}
	}
	
	private void searchBookContent() {
		String keyword = inputBookKeyword();
		List<Book> list = dao.selectAll();
		for(Book book : list) {
			if(book.getBookContent().indexOf(keyword) != -1) {
				System.out.println(book);
			}
		}
	}
	private String inputBookKeyword() {
		System.out.print("검색> ");
		return sc.next();
	}
	private void selectRentalBookList() {
		// TODO Auto-generated method stub
		List<Book> list = dao.selectAll();
		for(Book book : list) {
			if(book.getBookRental() == 0) {
				System.out.println(book);
			}
		}
	}
	private void rentalBook() {
		// TODO Auto-generated method stub
		//도서 제목 입력
		String bookName = inputBookName();
		//해당 도서 정보 조회
		Book book = dao.searchBook(bookName);
		//대여 여부 확인
		if(book != null ) {
			//대여된 경우 별도의 안내문구
			if(book.getBookRental() == 1) {
				System.out.println("해당 도서는 대여 중입니다");
			} else {
				//대여가 안된 경우 대여처리
				book.setBookRental(1);
				dao.update(book);
			}
		}
	}
	private void returnBook() {
		//도서 제목 입력
		String bookName = inputBookName();
		//해당 도서 정보 조회
		Book book = dao.searchBook(bookName);

		if(book != null) {
			//반납처리
			book.setBookRental(0);
			dao.update(book);
		} else {
			System.out.println("해당 도서의 정보가 존재하지 않습니다");
		}
	}
	private void insertBookInfo() {
		//책 정보 입력
		Book book = inputBookInfo();
		//책 정보 등록
		dao.insert(book);
	}
	
	private Book inputBookInfo() {
		Book book = new Book();
		System.out.println("도서 제목> ");
		book.setBookName(sc.next());
		System.out.println("저자명> ");
		book.setBookWriter(sc.next());
		System.out.println("도서 내용> ");
		book.setBookContent(sc.next());
		
		return book;
	}
	
	private String inputBookName() {
		System.out.println("도서 제목> ");
		return sc.next();
	}
	
	private void end() {
		System.out.println("프로그램 종료");
	}
}
