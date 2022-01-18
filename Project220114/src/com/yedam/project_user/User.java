package com.yedam.project_user;

public class User {
	private String userId;
	private String userPw;
	private String userNickname;
	private int auth = 1;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	
	@Override
	public String toString() {
		return "User [아이디=" + userId + ", 패스워드=" + userPw + ", 별명=" + userNickname + "]";
	}
	
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
}
