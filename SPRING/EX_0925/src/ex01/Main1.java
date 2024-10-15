package ex01;

import java.io.FileReader;
import java.util.Properties;

class Car{};
class SportsCar extends Car{};
class Truck extends Car{};
class Engine{};

public class Main1 {
	public static void main(String[] args) throws Exception{ 
		
	//객체는 함수로부터 반환받을 것임
	Car car = (Car)getCar("car");//:형변환을 여기서 해줌
	System.out.println("car= " + car);
	//주소값이 나오는 이유 : toString이 사용되었기때문임
	
	Engine engine = (Engine)getCar("engine");
	System.out.println("engine="+engine);
		
	}
	
	static Object getCar(String key) throws Exception{
		/*java.util.Properties클래스 : 키와 값의 쌍으로 구성된 속성 목록들을 관리할 때 사용함
												일반적으로 구성파일이나 속성파일에서 설정정보를 읽거나 쓸 때 사용함
		->사용법은 Map과 비슷함 : Properties는 (String,String)을 저장함	*/
		Properties p = new Properties();
		
		//load() : 파일이나 스트링으로부터 읽어올 때 사용함
		p.load(new FileReader("config.txt"));
		
		/*Class클래스 : 클래스 메타데이터를 제공하는 클래스임
		 ->Class.forName()
		 ->Class.getClass()메서드를 통해 클래스의 정보를 가져올 수 있음*/
		Class clazz = Class.forName(p.getProperty(key));
		
		return clazz.newInstance();
		/*newInstance() : 클래스정보를 가지고 동적으로 객체를 생성할 때 사용하는 메서드임
		매개변수가 없는 기본 생성자를 호출해서 객체를 생성해줌*/
	}
	
}
