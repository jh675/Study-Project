package com.yedam.project_app;

import java.util.*;

import com.yedam.project_board.*;
import com.yedam.project_user.*;

public class UserFrame {
	private BoardDAO bdDAO = BoardDAOImpl.getInstance();
	static Scanner sc = new Scanner(System.in);
	public UserFrame(User loginInfo) {
		while(true) {
			//메뉴 출력
			menuPrint();
			
			//메뉴 선택
			int menuNo = menuSelect();
			
			//메뉴별 실행
			switch(menuNo) {
			case 1: // 게시글 작성
				insertBoard();
				break;
			case 2: // 게시글 수정
				updateBoard();
				break;
			case 3: // 게시글 삭제
				deleteBoard();
				break;
			case 4: //게시글 조회
				selectAll();
				break;
			}
		}
	}

	private void insertBoard() {
		Board bd = inputBoardInfo();
		bdDAO.insert(bd);
	}

	private void updateBoard() {
		Board bd = inputBoardInfo();
		bdDAO.update(bd);
	}

	private void deleteBoard() {
		Board bd = inputBoardInfo();
		bdDAO.delete(bd);
	}

	private Board inputBoardInfo() {
		Board bd = new Board();
		System.out.print("게시글 제목> ");
		bd.setBdTitle(sc.next());
		System.out.print("게시글 본문>");
		bd.setBdContent(sc.next());
		return bd;
	}

	private void selectAll() {
		List<Board> list = bdDAO.selectAll();
		for(Board bd : list) {
			System.out.println(bd);
		}
	}

	public static void menuPrint() {
		System.out.println("-----------------------------------------------------");
		System.out.println("1.게시글 작성 | 2.게시글 수정 | 3.게시글 삭제 | 4.게시글 전체 조회");
		System.out.println("-----------------------------------------------------");
		System.out.print("선택> ");
	}
	
	public static int menuSelect() {
		int menuNo = 0;
		try {
			menuNo  = sc.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다");
		}
		return menuNo;
	}
}
