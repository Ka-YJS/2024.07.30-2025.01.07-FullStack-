package ex01_inner;
	/*
	문제)
	-Operation이라는 Enum을 만들고, PLUS("+"), MINUS("-"), MULTI("*"), DIVIDE("/")상수객체를 가짐
	-다음 추상메서드를 가짐
	public abstract double apply(double x, double y);
	-추상메서드를 구현하여 두 수의 연산을 한 값을 반환하도록 함
	-main에서 호출하여 연산결과 출력
	double x = 2.5;
	double y = 5.0;
	-결과 : 
	2.5+5.0 = 7.5
	2.5-5.0 = -2.5
	2.5*5.0 = 12.5
	2.5/5.0 = 0.5*/

public enum Operation {
	
	PLUS("+"){@Override
	public double apply(double x, double y) {
		return x+y;
	}}, 
	MINUS("-"){@Override
	public double apply(double x, double y) {
		return x-y;
	}}, 
	MULTI("*"){@Override
	public double apply(double x, double y) {
		return x*y;
	}}, 
	DIVIDE("/"){@Override
	public double apply(double x, double y) {
		return x/y;
	}};
	
	private String op;
	
	//생성자를 호출할 때 전달한 인자를 받는 생성자를 정의해야 함
	
	Operation(String op){
		this.op = op;
	}
	
	//private으로 설정된 필드의 값을 외부에서 보기 위해 메서드를 사용함
	public String getOp() {
		return op;
	}
	public abstract double apply(double x, double y);
	//추상메서드가 정의되면 상수객체에서 반드시 재정의해야 함
	
	}


