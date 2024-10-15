package ex02_object;

public class Ex01_equals {
	public static void main(String[] args) {
		
		String str1 = "Hello";//암시적 객체생성
		String str2 = "Hello";
		String str3 = new String("Hello");//명시적 객체 생성
		
		//문자열 변수 비교
		//암시적 객체생성을 할 때, 먼저 만들어져있는게 있으면 같이 참조함
		System.out.println("str1 vs str2 : " + (str1 == str2));//true -> 같은 주소값 참조
//		str1 = "Bye"; 
		//Q)str2와 같은 주소를 참조하므로 str2도  Bye로 바뀌어야 하는게 맞지않나?
//		System.out.println("str2 : "+str2);
		//A)결과는 str2 : Hello로 출력, 불변의 법칙
		System.out.println("str2 vs str3 : " + (str2 == str3));
		//false, 글씨는 같지만 다른 주소값을 가지고 있음 -> new를 통해서 만들었기때문
		
		//각 문자열 변수가 있는 위치의 값을 출력
		//System.identityHashCode( ) : 객체의 고유한 hashcode를 리턴하는 메서드
		//hashcode()는 다른 객체이지만 주소가 동일한 경우가 있을 수 있다.
		System.out.println("str1 hashCode : " + System.identityHashCode(str1));
		System.out.println("str2 hashCode : " + System.identityHashCode(str2));
		System.out.println("str3 hashCode : " + System.identityHashCode(str3));
		
		System.out.println("======================================");
		
		String str11 = "Hello";
		String str22 = "Hello";
		String str33 = new String("Hello");
		
		//문자열 변수 비교
		System.out.println("str1 vs str2 : " + (str11.equals(str33)));
		System.out.println("str2 vs str3 : " + (str22.equals(str33)));
		
		
		
	}
}
