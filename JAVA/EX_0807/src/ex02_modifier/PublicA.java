package ex02_modifier;

public class PublicA {
	
	
	public int a;
	
	private PublicA(int a) {
		this.a = a ;
	}
	
	public void printA() {
		System.out.println("PublicA클래스의 printA()메서드 호출");
	}
	
	
	DefaultC dc = new DefaultC(); //같은 패키지이기 때문에 객체생성 가능
	void methodA() {
		dc.varableC = 20; //public으로선언된 필드도 객체를 통해 접근 가능
	}
	
}
