package ex01_casting;

public class Ex01_Casting {

	public static void main(String[] args) {
		
		int num = 11;
		double num1Change = 3.14;
		
		num1Change = num; //정수를 실수형 변수에 대입
		
		int i = 100;
		char c = 'a';
		
		i=c;
		double d = i;
		System.out.println("i의 값 : "+i);
		System.out.println("d의 값 : "+d);
		
		

	}

}
