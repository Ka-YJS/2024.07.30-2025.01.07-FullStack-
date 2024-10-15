//package com.example.demo.di;
//
///*객체 자동 등록
// -스프링부트에서 어떻게 객체를 자동으로 만들어놓고 시작할 수 있는가?*/
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import com.google.common.reflect.ClassPath;
//
//@Component class Car{};
//@Component class SportCar extends Car{};
//@Component class Truck extends Car{};
//@Component class Engine {};
//
//class AppContext{//:객체 컨테이너 역할을 하는 클래스
//	Map map;
//	
//	public AppContext() {
//		map = new HashMap();//:객체를 저장하기위한 map을 준비
//		doComponentScan();//:컴포넌트 스캐닝을 해서 map에 저장해주는 메서드가 됨
//	}
//
//	private void doComponentScan() {
//		try {
//			  /*1. 패키지내의 클래스 목록을 가져옴
//				2. 반복문으로 클래스를 하나씩 읽어와서 @Component가 붙어있는지 확인
//				3. @Component가 붙어있으면 객체를 생성해서 map에 저장*/
//			
//		  /*AppContext 클래스의 클래스 로더를 가져옴
//		    -> 클래스 로더는 JVM에서 클래스를 동적으로 로드하고, 애플리케이션이 사용할 수 있도록 메모리에 적재하는 역할을 함*/
//			ClassLoader classLoader = AppContext.class.getClassLoader();
//			
//		/*ClassPath 객체를 생성하여 지정된 클래스 로더에서 클래스 경로를 읽음
//		ClassPath는 구아바(Guava) 라이브러리에서 제공하는 기능으로, 클래스 경로 상의 모든 클래스를 탐색하고 사용할 수 있게 도와줌*/
//			ClassPath classPath = ClassPath.from(classLoader);
//			
//			/*지정한 패키지("com.example.demo.di") 내의 최상위 클래스들(탑 레벨 클래스)을 가져옴
//			이 메서드는 지정된 패키지에서 상위 레벨 클래스를 탐색하고, 그 결과로 ClassPath.ClassInfo 객체들의 집합(Set)을 반환함*/
//			Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.example.demo.di");
//			
//			/*위에서 얻은 클래스 정보를 반복 처리함. 각 ClassPath.ClassInfo 객체는 특정 클래스에 대한 정보를 나타냄*/
//			for(ClassPath.ClassInfo classInfo : set) {
//			/*현재의 ClassInfo 객체를 실제로 로드된 클래스(Class)로 변환함
//			 이 메서드는 해당 클래스의 정보를 기반으로 JVM에서 해당 클래스를 로드하여 Class 객체를 반환함*/
//				Class clazz = classInfo.load();
//				
//			  /*해당 클래스에 @Component 애노테이션이 있는지 확인함
//			  @Component는 스프링에서 자주 사용되는 애노테이션으로, 빈으로 등록할 클래스에 부여됨
//			  클래스에 @Component 애노테이션이 있는지 확인하기 위해 리플렉션을 사용하여 애노테이션을 가져옴*/
//				Component component = (Component)clazz.getAnnotation(Component.class);
//				
//				/*@Component 애노테이션이 null이 아니면, 
//				 즉 해당 클래스가 @Component로 지정된 클래스라면 아래의 로직을 실행함(map에저장)*/
//				if(component != null) {//:여기서 키값을 설정함
//					
//					/*클래스 이름의 첫 글자를 소문자로 변환하여 id로 사용함
//					 -클래스의 이름을 가져와서 앞 글자를 소문자로 변환하는 이유는 스프링에서 빈을 생성할 때, 
//					  기본적으로 클래스 이름의 첫 글자를 소문자로 사용하기 때문임*/
//					String id = StringUtils.uncapitalize(classInfo.getSimpleName());
//					
//				/*해당 클래스를 인스턴스화(newInstance() 메서드 사용)하여, 생성된 객체를 id와 함께 맵에 저장함
//				-newInstance() 메서드는 기본 생성자를 호출하여 객체를 생성하며, 
//				-리플렉션을 사용하여 런타임에 동적으로 객체를 생성할 수 있음
//				 맵은 주로 의존성 주입 컨테이너의 역할을 수행할 때 사용되며, id는 빈의 이름, clazz.newInstance()는 해당 빈의 인스턴스임*/
//					map.put(id, clazz.newInstance());
//				}//if
//			}//for
//			
//		} catch (Exception e) {
//			
//		}//try-catch
//		
//	}//doComponentScan()
//	
//	//만들어진 객체를 사용하기위해서 getBean메서드를 만듦
//	Object getBean(String key) {
//		return map.get(key);
//		
//	}//Object1
//	
//	//by Type
//	Object getBean(Class clazz) {
//		for(Object obj : map.values()) {//map.values() : map에 있는 모든 value를 컬렉션으로 만듦
//			if(clazz.isInstance(obj)) {
//				return obj;//일치하는거 있으면 obj반환
//			}
//		}return null;//일치하는거 없으면 null을 반환
//	}//Object2
//	
//}//class AppContext
//
//public class Main {
//	public static void main(String[] args) {
//
//		AppContext ac = new AppContext();
//		
//		
//		Car car = (Car)ac.getBean("car");
//		System.out.println("car= " + car);
//		
//		Engine engine = (Engine)ac.getBean("engine");
//		System.out.println("engine= " + engine);//by Name으로 객체를 검색
//		
//		Truck truck = (Truck)ac.getBean(Truck.class);
//		System.out.println("truck = "+truck);//by Type으로 객체를 검색
//		
//		
//	}}
