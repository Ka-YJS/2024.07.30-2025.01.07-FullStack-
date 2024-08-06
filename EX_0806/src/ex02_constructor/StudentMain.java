package ex02_constructor;

public class StudentMain {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동", 20, 20240001);
		
		System.out.println("이름 : "+s1.name+" | 나이 : "+s1.age+" | 학번 : "+s1.studentId);
		//1차출력 : 결과값이 이름 : null // 나이 : 0 // 학번 : 0 로 나옴
		//2차출력 : Student로 가서 변수앞에 this.를 붙여주면 원하는대로 출력됨

	}

}
