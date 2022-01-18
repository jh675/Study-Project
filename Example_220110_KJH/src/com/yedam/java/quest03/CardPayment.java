package com.yedam.java.quest03;

public class CardPayment implements Payment {
	private double ratio;
	
	public CardPayment(double ratio) {
		this.ratio = ratio;
	}
	
	@Override
	public int online(int price) {
		// TODO Auto-generated method stub
		return (int)(price - price*(ratio + Payment.ONLINE_PAYMENT_RATIO));
	}

	@Override
	public int offline(int price) {
		// TODO Auto-generated method stub
		return (int)(price - price*(ratio + Payment.OFFLINE_PAYMENT_RATIO));
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("***간편 결제 시 할인정보***");
		System.out.println("온라인 결제 시 총 할인율: " + (ratio + Payment.ONLINE_PAYMENT_RATIO));
		System.out.println("오프라인 결제 시 총 할인율: " + (ratio + Payment.OFFLINE_PAYMENT_RATIO));
		
	}

}
