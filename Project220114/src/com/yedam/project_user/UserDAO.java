package com.yedam.project_user;

public interface UserDAO {
	//유저 아이디 조회
	public boolean selectUserId(String UserId);
	//유저 닉네임 조회
	public boolean selectUserNickname(String UserNickname);
	
	//유저 회원가입
	public void insertUser(User user);
	
	//유저 로그인
	public User loginUser(User user);
	
	//유저 정보 조회(관리자용)
	public void selectUserAll(User user);

	//유저 정보 수정(관리자용)
	public int updateUser(User user);

	//유저 추방(관리자용)
	public int killUser(String userId);
}
