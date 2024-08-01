package ex01_switch;

public class Ex03_switch {

	public static void main(String[] args) {
		
		//break가 없다면? -> 모든 케이스를 다 거쳐감		
		int num = 1;
		
		switch(num) {
		case 1 : 
			System.out.println("num은 1입니다.");
			
		case 7 : 
			System.out.println("num은 7입니다.");
			
		default :
			System.out.println("num은 7도 1도 아닙니다.");
		}
		
		
		System.out.println("----------------------");

	}

}
