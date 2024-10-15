package ex02_class;

public class Student {
	
	static String schoolName = "코리아 고등"; //:정적 멤버 선언
	
	String studentName;
	
	static void goToSchool() {
		System.out.println("학교에 갑니다.");}
	
	//인스턴스메서드
	void hello() {System.out.println("안녕하세요, 제 이름은 "+studentName+" 입니다.");}
	

}
