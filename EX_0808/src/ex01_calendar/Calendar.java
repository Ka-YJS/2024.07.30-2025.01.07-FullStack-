package ex01_calendar;

public class Calendar {
	
	//아래 두개를 필드로 갖음
	String color;
	int months;
	
	//1.  필드는 생성자를 통해 초기화 하기
	public Calendar(String color,int months) {
		this.color = color;
		this.months = months;
	}
	
	//2. xx색 달력은 xx월까지 있습니다. -> info
	public void info() {
		System.out.println(color+"색 달력은 "+months+"월까지 있습니다.");
	}
	//3. xx색 달력은 벽에 걸 수 있습니다. -> hanging
	public void hanging() {
		System.out.println(color+"색 달력은  벽에 걸 수 있습니다.");
	}

}
