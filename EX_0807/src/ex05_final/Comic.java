package ex05_final;

public class Comic extends Book {
	
	boolean isColor;
	
	public Comic(String title, String author, boolean isColor) {
		super(title, author);
		this.isColor = isColor;
		
	}
	

	@Override
	public void info_author() {
		System.out.println("이 만화책의 저자는 " + author+"입니다.");
	}

	/*
	부모클래스에서 final로 선언된 메서드를 오버라이딩 시도하면 에러가 발생한다.
	
	@Override
	public void info_title(){}
	
    */
	
	public void info_color() {
		if(isColor) {
			System.out.println("이 만화책은 컬러입니다.");
		} else {
			System.out.println("이 만화책은 흑백입니다.");
		}
	}

}
