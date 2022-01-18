package com.yedam.project_board;

import java.util.List;

public interface BoardDAO {
	//게시글 전체 조회
	public List<Board> selectAll();
	
	//게시글 작성
	public void insert(Board board);
	
	//게시글 수정
	public void update(Board board);
	
	//게시글 삭제
	public void delete(Board board);
}
