package ex02_object;

//자바의 모든 클래스는 Object클래스를 상속받음(명시하지않더라도)
public class Ex02_Car {
	
	private String carName;
	private String company;

	public Ex02_Car(String carName, String company) {
		this.carName = carName;
		this.company = company;
	}
	
	//자바의 모든 클래스는  Object클래스를 상속받음
	@Override
	public String toString() {
		String str = "차량 이름 : " + this.carName + ", 제조사 : " + this.company;
		return str;
	}

}
