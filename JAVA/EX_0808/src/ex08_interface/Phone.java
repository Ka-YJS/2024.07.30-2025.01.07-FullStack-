package ex08_interface;

public interface Phone {
	
	//들어갈 수 있는 것 : 상수 -> 상수명은 대문자로 작성, 추상메서드
	//값을 한번 넣으면 대입이 불가능
	public static final int MAX_BATTERY_CAPACITY = 100;
	
	//추상메서드 : 
	abstract void powerOn();
	//==void powerOn(); -> 인터페이스에는 추상메서드만 들어갈 수 있어서 abstract생략해도 됨
	abstract void powerOff();
	abstract boolean isOn();
	abstract void watchUtube();
	abstract void charge();
	

}
