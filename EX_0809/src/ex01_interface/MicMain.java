package ex01_interface;

public class MicMain {
	public static void main(String[] args) {
		
		/* 맨 처음 입력함 : 
		BluetoothMIC bm = new BluetoothMIC();
		
		bm.sing();
		bm.music();
		*/
		
		System.out.println("---TJmic 객체---");
		TJmic tj = new TJmic();//:인터페이스를 구현한 클래스의 객체
		tj.connect();
		tj.music();
		tj.sing();
		
		System.out.println("\n---TJmic 객체를 BluetoothMIC로 타입 변환---");
		BluetoothMIC bm = tj;
		bm.connect();
		bm.music();
		bm.sing();
		
		System.out.println("\n---TJmic 객체를 Microphone으로 타입 변환---");
		MicroPhone m = tj;
		//m.connect(); ->호출불가능
		//m.music(); ->호출불가능
		m.sing();
		
		System.out.println("\n--TJmic 객체를 Speaker로 타입 변환---");
		Speaker s = tj;
		//s.connect(); ->호출불가능
		s.music();
		//s.sing(); ->호출불가능

	}

}
