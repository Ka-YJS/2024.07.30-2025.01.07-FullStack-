package ex01_super;

public class Samsong extends Computer{
	
	@Override
	
	void powerOn() {
		super.powerOn();//:부모클래서의 메서드를 호출
		System.out.println("아이 러브 삼송");
	}

}
