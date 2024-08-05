package ex03_method;

public class Person {
	
	//이름과 나이를 전달받아 출력하는 introduce메서드 생성 -> "제이름은 ~이고, 나이는 x세입니다."
	
	void introduce(String name, int age) {
		System.out.printf("제 이름은 %s이고, 나이는 %d세 입니다.",name,age);
	}
	

}
