package ex02_constructor;

public class PhoneMain {

	public static void main(String[] args) {
		
		
		Phone p1 = new Phone("갤럭시",24,"흰색");//:앞서 정해놓은 매개변수를 정의해줘야 함
		//Phone p2 = new Phone("아이폰",16,"검정색");
		//Phone에서 매개변수 "검정색"을 줬지만 값은 넣어줘야하므로 적어줘야함
		Phone p2 = new Phone("아이폰",16);//:인자를 두개 넣으면 매개변수 2개짜리 생성자가 실행됨
		
		//자바에서는 생성자를 여러개 선언하는 것을 허용하고 있음
		//외부에서 제공할 수 있는 데이터만큼만 매개변수로 전달하여 객체를 생성할 수 있음
		

	}

}
