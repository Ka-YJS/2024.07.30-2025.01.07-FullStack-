package ex07_test;

	/*
	문제1)
	-정수형 변수 2개를 매개변수로 가지는 추상메서드  add(); -> 반환형 int
	-정수형 변수 2개를 매개변수로 가지는 추상메서드  substract(); -> 반환형 int
	-정수형 배열을 매개변수로 갖는 average()추상메서드 -> 반환형 double
	-GoodCalc클래스만들기 -> Calculator 상속 -> 더해서 반환 add, 빼서 반환 substract, 배열평균 average
	*/

public abstract class Calculator {
	
	public abstract int add(int x, int y);
	
	public abstract int substract(int x, int y);
	
	public abstract double average(int[]arr);
	
	

}
