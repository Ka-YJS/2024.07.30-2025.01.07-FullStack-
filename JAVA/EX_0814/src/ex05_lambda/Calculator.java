package ex05_lambda;

@FunctionalInterface
//@FunctionalInterface : 인터페이스에 추상메서드가 무조건 1개 있어야 함(0개거나 2개이상 -> 오류)
public interface Calculator {
	
	int plus(int num1,int num2);
	//하나의 추상메서드만 존재해야 함

}
