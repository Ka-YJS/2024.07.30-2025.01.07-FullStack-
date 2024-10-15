package ex04_Farm;

class Parent{
	public void display() {
		System.out.println("부모 클래스의 display( )메서드이다.");
	}
}

class Child extends Parent{
	
	//오버라이딩 된 display()메서드
	@Override
	public void display() {
		System.out.println("자식 클래스의 display( ) 메서드이다.");
	}
	
	//오버로딩된 display()메서드
	public void display(String str) {
		System.out.println(str);
	}
}

public class InheritanceMethodTest {
	public static void main(String[] args) {
		
		Child ch = new Child();
		ch.display();
		ch.display("오버로딩된 display()메서드입니다.");
		
	}

}
