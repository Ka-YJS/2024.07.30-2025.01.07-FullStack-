package ex01_interface;

/* 맨 처음 입력함 : 
 
public class BluetoothMIC implements MicroPhone, Speaker{
	
	@Override
	public void music() { System.out.println("음악이 나옵니다.");
		
	}

	@Override
	public void sing() { System.out.println("노래를 부릅니다.");
		
	}

}
*/

public interface BluetoothMIC extends MicroPhone, Speaker{

	abstract void connect();
}
