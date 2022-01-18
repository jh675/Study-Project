package com.yedam.java.quest04;

import java.util.*;

public class Example {

	private static Scanner sc;

	public static void main(String[] args) {
		boolean run = true;
		sc = new Scanner(System.in);
		
		List<Sechedule> list = new ArrayList<>();
		Sechedule sch = null;

		while (run) {
			System.out.println("=== 1.할일 입력 | 2.전체조회 | 3.할일조회 | 4.할일 완료 | 5.종료 ===");
			System.out.print("선택>");

			int menuNo = sc.nextInt();

			switch (menuNo) {
			case 1:
				System.out.print("할 일>");
				String schedule = sc.next();
				sch = new Sechedule(schedule);
				list.add(sch);
				break;
			case 2:
				for (Sechedule schTemp : list) {
					System.out.println(schTemp.getSchNo() + "번 " + schTemp.getSchedule() + " " + (schTemp.isComplete() ? "완료" : "미완료"));
				}
				break;
			case 3:
				for (Sechedule schTemp : list) {
					if(schTemp.isComplete() == false) {
						System.out.println(schTemp.getSchNo() + "번 " + schTemp.getSchedule() + " " + (schTemp.isComplete() ? "완료" : "미완료"));
					}
				}
				break;
			case 4:
				System.out.print("완료할 일>");
				schedule = sc.next();
				
				for(Sechedule schTemp : list) {
					if(schTemp.getSchedule().equals(schedule)) {
						if(schTemp.isComplete()) {
							System.out.println("해당 할 일은 이미 완료되었습니다.");
						}else {
							schTemp.setComplete(true);
							System.out.println("해당 할 일을 완료처리하였습니다");
						}
					}
				}
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료");
				break;
			}
		}
	}

}
