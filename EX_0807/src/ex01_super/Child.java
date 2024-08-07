package ex01_super;

public class Child extends Parent {
	
	public Child(int n) { //:매개변수 이름은 int n이 아닌 int s를 사용해도 문제되지않음
		super(n);//:부모생성자의 호출, 생략해도 눈에만 안보일 뿐 기본생성자가 생성되어 있음
				//:부모클래서의 생성자에 매개변수가 없으면 생략가능, 있으면 생략x
	}
	

}
