package ex01_switch;

public class Ex02_switch {

	public static void main(String[] args) {
		
		
		String str = "홍";
		String result;
		
		switch(str) {
		case "박" : 
			result = "박길동";
			break;
		case "이" : 
			result = "이길동";
			break;
		case "독고" : 
			result = "독고길동";
			break;
		case "홍" : 
			result = "홍길동";
			break;
			
		default :
			result = "일치하는 성이 없음";
			break;
		}System.out.println(result);
		
		
		System.out.println("-------------------");
		
		char ch = 'B';
		
		switch(ch) {
		case 'A' : 
			System.out.println("A");
			break;
		case 'B' : 
			System.out.println("B");
			break;
		case 'C' : 
			System.out.println("C");
			break;
		case 'D' : 
			System.out.println("D");
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
