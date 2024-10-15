package ex01_lambda;

interface Interface{
	
	//추상메서드 : 
	abstract void  methodA();
	abstract void  methodB();
	abstract void  methodC();
	
	/*
	1. 메서드 앞에 default예약어를 붙임
	2. body(구현부)가 있어야 함
	*/
	default int defaultMethodA() {
		System.out.println("디폴트 메서드 A");
		return 10;
		
	}
}

class InterImpl implements Interface{
	//사용여부 상관없이 일단 인터페이스의 모든 추상메서드를 오버라이딩해야 함

	@Override
	public void methodA() {
		System.out.println("오버라이딩 된 메서드 A");
	}

	@Override
	public void methodB() {
	}

	@Override
	public void methodC() {
	}
	
}

public class ex02_DefaultMethod {
	public static void main(String[] args) {
		Interface inter = new InterImpl();
		inter.methodA();
		inter.defaultMethodA();
	}

}
