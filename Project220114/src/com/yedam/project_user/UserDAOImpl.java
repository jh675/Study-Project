package com.yedam.project_user;

import com.yedam.project_common.DAO;

public class UserDAOImpl extends DAO implements UserDAO {
	private static UserDAO instance = new UserDAOImpl();
	private UserDAOImpl() {}
	public static UserDAO getInstance() {
		return instance;
	}
	@Override
	public boolean selectUserId(String UserId) { // 인수로 들어온 ID에 해당하는 레코드 검색하여 중복여부 체크하기 리턴값이 true =사용가능 , false = 중복
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			connect();
			String select = "SELECT * FROM User WHERE user_id = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, UserId.trim());
			rs = pst.executeQuery();
			if(rs.next()) {
				result = false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return result;
	}
	@Override
	public boolean selectUserNickname(String UserNickname) { // 인수로 들어온 Nickname에 해당하는 레코드 검색하여 중복여부 체크하기 리턴값이 true =사용가능 , false = 중복
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			connect();
			String select = "SELECT * FROM User WHERE user_nickname = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, UserNickname.trim());
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				result = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
		return result;
	}
	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		try {
			connect();
			String insert = "INSERT INTO User VALUES(?, ?, ?, ?)";
			pst = conn.prepareStatement(insert);
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getUserPw());
			pst.setString(3, user.getUserNickname());
			pst.setInt(4, user.getAuth());


			int result = pst.executeUpdate();

			System.out.println(result + "명이 가입하였습니다");

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}

	}
	@Override
	public User loginUser(User user) {
		// TODO Auto-generated method stub
		try {
			connect();
			String select = "SELECT auth FROM User WHERE user_id = ?";
			pst = conn.prepareStatement(select);
			pst.setString(1, user.getUserId());
			rs = pst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
		return user;
	}
	@Override
	public void selectUserAll(User user) { //모든 
		// TODO Auto-generated method stub
		try {
			connect();
			String select = "SELECT * FROM User ORDER BY user_id";
			pst = conn.prepareStatement(select);
			rs = pst.executeQuery();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			connect();
			String update = "UPDATE User SET user_pw = ?, user_nick = ? WHERE user_id = ?";
			pst = conn.prepareStatement(update);
			pst.setString(1, user.getUserPw());
			pst.setString(2, user.getUserNickname());
			pst.setString(3, user.getUserId().trim());
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
		return result;
	}
	@Override
	public int killUser(String userId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			connect();
			String delete = "DELETE User WHERE user_id = ?";
			pst = conn.prepareStatement(delete);
			pst.setString(1, userId.trim());
			result = pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
		return result;
	}
}
