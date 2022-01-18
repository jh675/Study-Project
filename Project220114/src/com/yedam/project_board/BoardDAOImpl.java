package com.yedam.project_board;

import java.util.*;

import com.yedam.project_common.DAO;

public class BoardDAOImpl extends DAO implements BoardDAO {
	private static BoardDAO instance = new BoardDAOImpl();
	private BoardDAOImpl() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Board> selectAll() { //게시글 목록
		List<Board> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM Board ORDER BY bd_id";
			pst = conn.prepareStatement(select);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Board bd = new Board();
				bd.setBdId(rs.getInt("bd_id"));
				bd.setBdTitle(rs.getString("bd_title"));
				bd.setBdTime(rs.getDate("bd_time"));
				bd.setBdContent(rs.getString("bd_content"));
				
				list.add(bd);
			}
			
		} catch (Exception e) {
			System.out.println("게시글 목록을 조회할 수 없습니다.");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void insert(Board board) { //게시글 작성
		try {
			connect();
			String insert = "INSERT INTO Board (bd_title, bd_content) VALUES(?, ?)";
			pst = conn.prepareStatement(insert);
			pst.setString(1, board.getBdTitle());
			pst.setString(2, board.getBdContent());
			
			int result = pst.executeUpdate();
			
			if(result > 0) {
				System.out.println("게시글이 등록되었습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("게시글을 등록하지 못했습니다.");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void update(Board board) { //게시글 수정
		try {
			connect();
			String update = "UPDATE Board SET bd_content = ? WHERE bd_id = ?";
			pst = conn.prepareStatement(update);
			pst.setString(1, board.getBdContent());
			pst.setInt(2, board.getBdId());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				System.out.println("게시글의 수정이 완료되엇습니다.");
			}
		} catch (Exception e) {
			System.out.println("게시글을 수정하지 못했습니다.");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void delete(Board board) { //게시글 삭제
		try {
			connect();
			String delete = "DELETE FROM Board WHERE bd_title = ?";
			pst = conn.prepareStatement(delete);
			pst.setString(1, board.getBdTitle());
			
			int result = pst.executeUpdate();
			if(result > 0) {
				System.out.println("게시글이 삭제되었습니다.");
			}
		} catch (Exception e) {
			System.out.println("게시글을 삭제하지 못했습니다.");
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
