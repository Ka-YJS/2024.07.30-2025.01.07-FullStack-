package ex03_variable;

public class Ex_variable02 {

	public static void main(String[] args) {

		
		boolean b = true;
		System.out.println("b의 값 : " + b);
		
		b = false;
		System.out.println("b의 값 : " + b);
		
		
		//b = 1; -> 자료형의 값이 올바르지 않아 오류가 발생
		
		System.out.println("--------------");
		
		char ch = 'A';
		
		System.out.println("ch의 값 : " + ch);
		
		ch = 66;
		System.out.println("ch의 값 : " + ch);

		
		System.out.println("--------------");
		

		byte b1 = 125;
		short s = 3267;
		int n = 550;
		
		System.out.println("b1의 값 : "+b1);
		System.out.println("s의 값 : "+s);
		System.out.println("n의 값 : "+n);
		
		System.out.println("--------------");

		float f = 3.14f;
		System.out.println("f의 값 : "+f);

		float f1=3.14f, f2=1.23f;
		System.out.println("f1의 값 : "+f1+" // "+"f2의 값 : "+f2);

		
		System.out.println("--------------");

		//변수를 이용해 다른 변수에 값 복사하기
		int myAge = 23;
		int yourAge = myAge;
		
		System.out.println("내 나이 : "+myAge+" // "+"친구 나이 : "+yourAge);

		
		System.out.println("--------------");
		
		
		//두 변수에 들어있는 값을 바꾸려면 어떻게 해야하는가?
		
		int su1 = 20, su2 = 30;
		
		System.out.println("변경전");
		System.out.println("su1 : "+su1);
		System.out.println("su2 : "+su2);
		
		//내용물을 임시로 담아놓을 컵이 필요함
		
		int temp = su1;
		su1 = su2;
		su2 = temp;
		
		System.out.println("변경후");
		System.out.println("su1 : "+su1);
		System.out.println("su2 : "+su2);
		

		
		
	}

}
