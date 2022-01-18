package com.yedam.project_board;

import java.sql.Date;

public class Board {
	private int bdId;
	private String bdTitle;
	private String bdContent;
	private Date bdTime;
	private String userId;

	public int getBdId() {
		return bdId;
	}

	public void setBdId(int bdId) {
		this.bdId = bdId;
	}

	public String getBdTitle() {
		return bdTitle;
	}

	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}

	public String getBdContent() {
		return bdContent;
	}

	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}

	public Date getBdTime() {
		return bdTime;
	}

	public void setBdTime(Date date) {
		this.bdTime = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
