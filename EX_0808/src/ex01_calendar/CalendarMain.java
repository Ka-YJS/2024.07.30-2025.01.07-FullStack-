package ex01_calendar;

public class CalendarMain {
	public static void main(String[] args) {
		
		DeskCalendar dc = new DeskCalendar("보라",6);
		dc.info();//:오버라이딩된 메서드가 호출됨
		dc.hanging();//부모클래스에 있는 메서드
		dc.onTheDesk();//자식클래스에만 있는 메서드
		
		System.out.println();
		System.out.println("==========================");
		
		Calendar c = new DeskCalendar("검정", 12);
		c.info();//부모타입으로 변환해도 오버라이딩된 메서드가 호출됨
		c.hanging(); 
		//c.onTheDesk(); 에러
		
		//부모클래스

	}

}
