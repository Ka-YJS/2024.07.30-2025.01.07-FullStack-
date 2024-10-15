package ex05_overriding;

public class ComputerMain {
	
	public static void main(String[] args) {
		
		Samsong s = new Samsong();
		s.powerOn();
		s.powerOff();//:자식클래스 먼저 실행됨
		
		Computer c = new Computer();
		c.powerOn();
		c.powerOff();

		
	}

}
