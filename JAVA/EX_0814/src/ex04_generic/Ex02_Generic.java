package ex04_generic;

interface Person{
	
}

class Student implements Person{
	
}

class Worker {
	
}

//Person인터페이스를 구현한 클래스만 제네릭타입으로 들어올 수 있음
class School<T extends Person>{
	
}

public class Ex02_Generic {
public static void main(String[] args) {
	//School<Woker>s1 = new School<>(); -> 오류, Worker class가 Person 인터페이스를 구현하지않았기때문임
	  School<Student>s2 = new School<>();
	
	
	
}
}
