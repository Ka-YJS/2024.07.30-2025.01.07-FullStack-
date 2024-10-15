package ex03_anonymous_class;

//Person클래스를 확장하기 위해 자식 클래스를 만들어서 사용
public class Student extends Person {
	
	@Override
	public void mySelf() {
		System.out.println("나는 학생입니다.");
	}

}
