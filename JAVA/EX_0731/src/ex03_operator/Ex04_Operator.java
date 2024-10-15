package ex03_operator;

public class Ex04_Operator {

	public static void main(String[] args) {
		
		//대입연산자
		
		int x = 10;
		int y = 3;
		
		y += x; // y = y + x;
		System.out.println(y);
		
		y *= x; // y = y * x; -> 여기서 y의 값은 위에 값을 받아 13, 최종 답은 130
		System.out.println(y);
		
		y %= x; // y = y % x; 
		System.out.println(y);
		
		y /= x; // y = y / x; 
		System.out.println(y);
		
		
		System.out.println("========================================");
		
		//비교연산자
		
		int a = 10;
		int b = 20;
		
		boolean result1 = a > b;
		System.out.println(result1);

		boolean result2 = a <= b;
		System.out.println(result2);

		boolean result3 = a == b;
		System.out.println(result3);

		boolean result4 = a != b;
		System.out.println(result4);

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
