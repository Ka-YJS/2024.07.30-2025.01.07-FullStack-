package ex02_constructor;

public class Book {
	
	//여러개의 생산자 선언해보기
	
	String title = "제목없음";
	int series = 1;
	int page = 100;
	
	public Book() {//:기본생성자
		
	}
	
	//제목만 넘겨받는 생성자
	public Book(String t) {
		title = t;
	}
	
	//제목과 페이지수 넘겨받는 생성자
	public Book(String t, int p) {
		title = t;
		page = p;
	}
	
	//시리즈와 제목을 넘겨받는 생산자
	public Book(int s, String t) {
		series = s;
		title = t;}
	
	
	public void bookInfo() {
		System.out.println("제목 : " + title);
		System.out.println("시리즈 : " + series);
		System.out.println("페이지 : " + page);
		
		System.out.println("============================");
	}
	
	
}
