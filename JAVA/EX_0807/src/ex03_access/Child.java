package ex03_access;

import ex02_modifier.Parent;//:다른패키지에있어도 import해서 연결하기

public class Child extends Parent {
	
	void accessTest() {
		
		//Protected가 붙은 메서드도 아래와 같은 방법으로 접근 가능
		super.accessProtected();
		
		Parent p1 = new Parent();
		
	//	p1.accessProtected(); 자식클래스더라도 객체로 접근하는 것은 불가능함
		
	}
	
	

}
