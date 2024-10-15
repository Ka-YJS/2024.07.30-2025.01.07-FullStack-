package ex05_lambda;

public class Ex01_lambda {
	public static void main(String[] args) {

		//클래스를 직접 생성, 객체를 만들어서 호출하는 방식
		Calculator cal1 = new CalculatorImpl();
		
		int res = cal1.plus(10,20);
		System.out.println("cal1 : "+res);
		System.out.println("--------------------------");
		
		//익명클래스를 통한 구현
		Calculator cal2 = new Calculator() {
			@Override
			public int plus(int num1, int num2) {
				return num1+num2;
			}
		};
		res = cal2.plus(10, 20);
		System.out.println("cal2 : "+res);
		System.out.println("--------------------------");
		
		//람다식을 통한 구현
		Calculator cal3 = (num1,num2)->num1 +num2;
		
		res = cal3.plus(10, 20);
		System.out.println("cal3 : " + res);
		System.out.println("--------------------------");
		
		//파라미터가 1개인 메서드 람다식으로 만들기
	//1)Myfunction mf = (int num) -> {System.out.println(num);};
	//2)Myfunction mf = num -> System.out.println(num);
	//3)	
		Myfunction mf = System.out :: println;
		mf.method(10);
		//::은 메서드 참조연산자 이중콜론으로, 람다식을 보다 간결하게 사용할 수 있도록 해줌
		
		
		
	}}
