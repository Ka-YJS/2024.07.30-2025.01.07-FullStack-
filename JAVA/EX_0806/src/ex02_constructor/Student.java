package ex02_constructor;

public class Student {
	
	//전역변수 : 
	String name;
	int age;
	int studentId;
	
	public Student(String name, int age,int studentId ) {
		//전역변수와 지역변수의 이름이 같을 때 우선권이 지역변수에 있음
		this.name = name;
		this.age = age;
		this.studentId = studentId;
	}
	

}
