package com.yedam.project_app;

import java.util.Scanner;

import com.yedam.project_user.*;

public class ProjectExample {
	private static Scanner sc = new Scanner(System.in);
	private static UserDAO dao = UserDAOImpl.getInstance();
	private static User loginInfo;
	
	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			//메뉴 출력
			menuPrint();
			
			//메뉴 선택
			int menuNo = menuSelect();
			
			//메뉴별 실행
			switch(menuNo) {
			case 1: // 회원 가입
				insertUser();
				break;
			case 2: // 로그인
				login();
				break;
			case 3: // 종료
				run = false;
				System.out.println("종료");
				break;
			}
		}
	}

	private static void insertUser() {
		User user = Join(); //회원가입 정보 입력
		
		dao.insertUser(user);
		
		System.out.println("회원가입이 완료되었습니다.");
	}

	//회원가입 정보 입력
	private static User Join() {
		User user = new User();
		System.out.print("아이디> ");
		user.setUserId(checkUserIdInfo(sc.next()));
		System.out.print("패스워드> ");
		user.setUserPw(sc.next());
		System.out.print("닉네임> ");
		user.setUserNickname(checkUserNicknameInfo(sc.next()));
		
		return user;
	}
	
	private static String checkUserNicknameInfo(String next) { //닉네임 중복확인
		boolean user = dao.selectUserNickname(next);
		if(user == true) {
			System.out.println("사용가능한 닉네임입니다");
			return next;
		} else {
			System.out.println("중복되는 닉네임입니다.");
			return null;
		}
	}

	private static String checkUserIdInfo(String next) { //아이디 중복 확인
		boolean user = dao.selectUserId(next);
		if(user == true) {
			System.out.println("사용가능한 아이디입니다");
			return next;
		} else {
			System.out.println("중복되는 아이디입니다.");
			return null;
		}
	}

	private static void login() {
		// 접속할 아이디, 패스워드 입력 -> inputLoginInfo()
		// 접속할 계정의 존재여부 확인 ->loginInfo()
		User user = loginInfo(inputLoginInfo());
		User loginUser = UserDAOImpl.getInstance().loginUser(user);
		// 접속할 경우 유저 프레임으로 이동.
		if(loginUser.getAuth() == 0) {
			new AdminFrame();
		} else if(loginUser.getAuth() == 1) {
			new UserFrame(loginInfo);
		}
	}
	
	private static User inputLoginInfo() {
		User user = new User();
		System.out.print("아이디> ");
		user.setUserId(sc.next());
		System.out.print("패스워드> ");
		user.setUserPw(sc.next());
		
		return user;
	}

	private static User loginInfo(User user) {
		user = dao.loginUser(user);
		return user;
	}

	public static void menuPrint() {
		System.out.println("-------------------------");
		System.out.println("1.회원가입 | 2.로그인 | 3.종료");
		System.out.println("-------------------------");
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