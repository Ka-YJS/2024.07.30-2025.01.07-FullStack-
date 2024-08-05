package ex03_method;

public class JorggerMain {

	public static void main(String[] args) {
		
		Jogger jogger = new Jogger(); //객체 생성
		jogger.run(); //jogger인스턴스의 run()메서드 호출
		
		System.out.println("================");
		
		jogger.name = "김나비";
		jogger.sayName();
		jogger.run();

	}

}
