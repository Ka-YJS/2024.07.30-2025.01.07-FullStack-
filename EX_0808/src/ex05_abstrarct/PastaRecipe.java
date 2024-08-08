package ex05_abstrarct;

public class PastaRecipe extends Recipe {
	
	public PastaRecipe(String chef) {
		super(chef); //부모클래스의 생성차 호출
	}
	
	void makeSource() {
		System.out.println("파스타 소스를 직접 만듭니다.");
	}

}
