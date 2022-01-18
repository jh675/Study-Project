package com.yedam.java.quest04;

public class Sechedule {
private static int serialNum = 0;
	
	private int schNo;			//할 일 번호
	private String schedule;	//할 일
	private boolean complete;	//할 일 완료여부
	
	public Sechedule(String schedule) {
		serialNum++;
		this.schNo = serialNum;
		this.schedule = schedule;
		this.complete = false;
	}
	
	public int getSchNo() {
		return schNo;
	}
	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
}