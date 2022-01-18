package com.yedam.java.quest02;

public class DGBCard extends Card {
	private String company = "대구은행";
	private String cardStaff;
	
	public DGBCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		super.showCardInfo();
		System.out.printf("담당직원 - %s, %s",cardStaff, company);
	}
}