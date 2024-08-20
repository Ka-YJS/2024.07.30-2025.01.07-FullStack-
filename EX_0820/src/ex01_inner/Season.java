package ex01_inner;

public enum Season {
	
	//1. 생성자에 값을 전달하는 것과 같은 원리임
	SPRING("봄","spring"),
	SUMMER("여름","summer"),
	FALL("가을","fall"),
	WINTER("겨울","winter");//상수 하나하나를 객체라고 보면 됨
	//class로 따지면 public static final Season SPRING = new Season("봄"); 과 같음
	
	//3. 필드에 전달됨
	private String season;
	private String e_season;
	
	//2. 전달한 값을 생성자를 통해서 받음
	Season(String season, String e_season){
		this.season = season;
		this.e_season = e_season;
	}
	public String getSeason() {
		return season;
	}
	public String getE_season() {
		return e_season;
	}

	}
	
