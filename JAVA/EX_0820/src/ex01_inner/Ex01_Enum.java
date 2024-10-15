package ex01_inner;

import java.util.Arrays;

public class Ex01_Enum {
	public static void main(String[] args) {

		//value( ) : 열거형 상수안에 들어있는 내용들을  enum타입의 배열로 반환
		Item[] items = Item.values();
		System.out.println(Arrays.toString(items)); //Arrays 클래스 import
		
		System.out.println("===============================");
    
		//name( ) : 열거객체가 가지고있는 문자열을 반환, ordinal( ) : 열거타입을 정의할 때 주어진 순번을 반환
		for(Item item : items) {
			System.out.println("name="+item.name()+",ordinal = "+item.ordinal());
		}
    
		//valueOf( ) : 매개변수로 주어지는 문자열과 동일한 문자열을 가지는 열거객체를 반환
		Item i1 = Item.START;
		Item i2 = Item.valueOf("START");
		Item i3 = Item.valueOf(Item.class,"START");
		Item i4 = Item.STOP;
		
		//열거형의 상수간에 비교는 ==을 사용함(상수의 주소 비교)
		System.out.println(i1 == i2);//초과, 미만, 이상, 이하와 같은 비교연산자는 사용x
		//기준객체.compareTo(비교객체);, 매개값을 주어진 객체를 비교해서 순번 차이를 반환함
		//기준객체가 비교객체보다 빠름 -> 음수 반환, 기준객체가 비교객체보다 느림 -> 양수 반환함
		
		System.out.println(i1.compareTo(i3));
		
		
  //  System.out.println(d1 > d4);//오류남`
    
	switch(i1) {
	case START://Item.START라고 쓸 수 없다.
		System.out.println("게임시작!");
	break;
	case STOP:
		System.out.println("게임멈춤!");
	break;
	case EXIT:
		System.out.println("게임종료!");
	break;
	}
	
	/*==위와 같은 내용임
	switch(i1) {
	case START -> System.out.println("게임시작!");
	case STOP -> System.out.println("게임멈춤!");
	case EXIT -> System.out.println("게임종료!");
	}*/
	
	//생성자가 private이기 때문에 열거형 객체를 직접 만드는 것은 불가능 함
	Season s = Season.SUMMER;
	System.out.println(s.name());
	System.out.println("계절명 : "+s.getSeason()+"("+s.getE_season()+")");
	

	}}
