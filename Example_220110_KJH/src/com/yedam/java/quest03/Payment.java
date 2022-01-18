package com.yedam.java.quest03;

public interface Payment {
	public final double ONLINE_PAYMENT_RATIO = 0.5;
	public double OFFLINE_PAYMENT_RATIO = 0.03;
	
	public abstract int online(int price);
	public int offline(int price);
	public void showInfo();
	
}
