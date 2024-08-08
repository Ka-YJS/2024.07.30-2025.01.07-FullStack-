package ex03_polymorphism;

public class ComputerRoom { //:컴퓨터실
	
	/*
	
	//필드에 있는 것이 기본 자료형이 아닌 객체 -> String str;과 같음
	Samsung com1;
	Samsung com2;
	
	LZ com1;
	LZ com2;
	
	*/
	
	
	Computer com1;
	Computer com2;
	Computer com3;
	
	public void allPowerOn( ) {
		com1.powerOn( );
		com2.powerOn( );
	}
	
	public void allPowerOff( ) {
		com1.powerOff( );
		com2.powerOff( );
	}

}
