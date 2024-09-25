package ex02;

import java.util.Map;
import java.util.HashMap;

class Car{};
class SportsCar extends Car{};
class Truck extends Car{};
class Engine {};

class AppContext{
	Map map;//객체 저장소
	
		public AppContext(){
			map = new HashMap();//컬렉션
			map.put("car", new SportsCar());
			map.put("engine", new Engine());
		}
		
		Object getBean(String key) {
			return map.get(key);//반환되는 내용 : new Sportscar
		}
}

public class Main2 {
	public static void main(String[] args) {
		
		AppContext ac = new AppContext();//:객체를 호출하면서 위에 class객체들도 한꺼번에 생성됨
		
		Car car = (Car)ac.getBean("car");//반환형이 obj라서 car타입으로 변환해줘야 함
		System.out.println("car= " + car);
		
		Engine engine = (Engine)ac.getBean("engine");
		System.out.println("engine= " + engine);
		
		
		
	}}
