package com.yedam.java.quest02;

public class Card {
	private String cardNo;
	private int validDate;
	private int cvc;
	
	public Card(String cardNo, int validDate, int cvc) {
		this.cardNo = cardNo;
		this.cvc = cvc;
		this.validDate = validDate;
	}
	
	public String getCardNo() {
		return cardNo;
	}

	public int getValidDate() {
		return validDate;
	}

	public int getCvc() {
		return cvc;
	}
	
	public void showCardInfo() {
		System.out.printf("카드정보 ( Card NO: %d 유효기간: %d CVC: %d )\n", 
				cardNo, validDate, cvc);
	}
}
