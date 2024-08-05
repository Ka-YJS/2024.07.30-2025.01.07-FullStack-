package ex03_method;

public class BookMain {

	public static void main(String[] args) {
		
		
		Book myBook = new Book();
		//:객체 생성 -> 메서드에 매개변수가 선언되어있다면 호출할 때 값을 전달하지 않으면 에러남
		myBook.count(3); //:myBook 인스턴스 count메서드 호출

	}

}
