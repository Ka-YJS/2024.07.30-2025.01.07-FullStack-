package ex07_class_casting;

class Car{};
class Bus extends Car{};
class SchoolBus extends Bus{
	int window = 4;
};

class OpenCar extends Car{};
class SportCar extends OpenCar{};

public class Ex02_class_casting {
	
	public static void main(String[] args) {
		Car c1 = new SchoolBus(); //1차 상속 관계가 아니더라도 자동 타입 변환 가능
		Bus b1 = new Bus();
		Bus b2 = new SchoolBus();
		
		SchoolBus sb = new SchoolBus();
		System.out.println("창문의 개수 : "+sb.window);
		
	//	System.out.println("창문의 개수 : "+b2.window); -> 부모타입으로 만들어서 자식클래스에서 추가된 객체 사용x
		
		Car c2 = new OpenCar();
		OpenCar oc = new SportCar();
		
		//Bus b3 = new OpenCar(); 오류
		//Bus b4 = new SportCar(); 오류
	}

}
