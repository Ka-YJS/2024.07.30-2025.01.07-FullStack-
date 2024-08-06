package ex04_inheritance;

public class BookMain {

	public static void main(String[] args) {
		
		//자식클래스는 부모클래스의 필드와 메서드를 가져다 사용할 수 있음
		
		//Comic클래스의 객체 생성 : 
		Comic comicBook = new Comic();
		comicBook.title = "포켓몬";
		comicBook.price = 4500;
		comicBook.info();

	}

}
