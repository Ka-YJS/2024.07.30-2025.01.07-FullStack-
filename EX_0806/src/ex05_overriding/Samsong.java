package ex05_overriding;

public class Samsong extends Computer{
	
	@Override
	
	//같은 메서드이지만 자식클래스의 상황에 맞게 재정의 하는 것
	void powerOn() {
		System.out.println("아이 러브 삼송");
	}

}
