package ex02_constructor;

public class BookMain {

	public static void main(String[] args) {
		
		Book b1 = new Book();
		System.out.println("제목 : " + b1.title);
		System.out.println("시리즈 : " + b1.series);
		System.out.println("페이지 : " + b1.page);
		
		System.out.println("============================");
		
		Book b2 = new Book("멘토시리즈 자바");
		System.out.println("제목 : " + b2.title);
		System.out.println("시리즈 : " + b2.series);
		System.out.println("페이지 : " + b2.page);
		
		System.out.println("============================");
		
		Book b3 = new Book("신데렐라",170);
		System.out.println("제목 : " + b3.title);
		System.out.println("시리즈 : " + b3.series);
		System.out.println("페이지 : " + b3.page);
		
		System.out.println("============================");
		
		Book b4 = new Book(5,"노인과 바다");
		System.out.println("제목 : " + b4.title);
		System.out.println("시리즈 : " + b4.series);
		System.out.println("페이지 : " + b4.page);
		
		System.out.println("============================");
		
		//Book에서 bookInfo로 만들어주면 코드는 절약되고 결과물은 똑같음
		Book b5 = new Book(6,"반지의제왕");
		b5.bookInfo();
		
		
		
		
		
		
		
		
		

	}

}
