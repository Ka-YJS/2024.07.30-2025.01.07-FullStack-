package ex06_calendar;

import java.util.Calendar;

public class Ex01_Calendar {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println("오늘 날짜는 " + year + "년 " + month+"월 " + day+"일 입니다.");
		

	}
}
