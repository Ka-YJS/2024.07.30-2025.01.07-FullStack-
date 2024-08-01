package ex01_switch;

public class Ex04_switch {

	public static void main(String[] args) {
		
		//java v.12이상에서의 switch문 : 조건에 복수의 값을 사용하는 것이 가능해짐
		//-> 화살표표현식 이용가능, 기존과 달리 해당하는 명령만 실행, 그 이후 case들은 실행X
		
		//이전 switch문
		String day = "MONDAY";
		
		switch(day) {
		case "MONDAY" :
		case "TUSEDAY" :
		case "WENDSDAY" :
		case "THURSDAY" :
		case "FRIDAY" :
		
			System.out.println("평일");
			break;
		case "SATURDAY":
		case "SUNDAY":
			System.out.println("주말");
			break;
		default : 
			System.out.println("잘못된 입력");
			break;
		}
		
		//java v.12이상에서의 switch문
		
		switch(day) {
		case "MONDAY","TUSEDAY","WENDSDAY","THURSDAY","FRIDAY" -> System.out.println("평일");
		case "SATURDAY","SUNDAY" -> System.out.println("주말");
		default -> System.out.println("잘못된 입력");
		}


	}

}
