package com.yedam.project_app;

import java.util.*;

import com.yedam.project_board.*;

public class AdminFrame {
	private BoardDAO bdDAO = BoardDAOImpl.getInstance();
	static Scanner sc = new Scanner(System.in);
	boolean run = true;
	
	public AdminFrame() {
		while(run) {
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
			case 4: // 게시글 조회
				selectAll();
				break;
			case 5: // 회원 조회(x)
				selectUser();
				break;
			case 6: // 회원 정보 수정(x)
				updateUser();
				break;
			case 7: // 회원 추방(x)
				killUser();
				break;
			case 8: //로그 아웃(x)
				logout();
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
		System.out.print("게시글 날짜>");
		bd.getBdTime();
		System.out.print("게시글 본문>");
		bd.setBdContent(sc.next());
		return bd;
	}

	private void selectAll() {
		List<Board> list = new ArrayList<>();
		for(Board bd : list) {
			System.out.println(bd);
		}
	}

	private void selectUser() {
		
	}
	
	private void updateUser() {
		
	}

	private void killUser() {
		
	}

	private void logout() {
		System.out.println("로그아웃 되었습니다.");
		run = false;
		new ProjectExample();
	}

	public static void menuPrint() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("1.게시글 작성 | 2.게시글 수정 | 3.게시글 삭제 | 4.게시글 전체 조회 | 5.회원 조회| 6. 회원 추방 | 7. 로그아웃");
		System.out.println("-----------------------------------------------------------------------------------------");
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
