package ex05_abstrarct;

public class RecipeMain {
	public static void main(String[] args) {
		
		//Recipe r = new Recipe(); -> 추상클래스는 직접 객체를 생성할 수 없음
		
		PastaRecipe pr = new PastaRecipe("최연석");
		pr.info(); //자식객체를 통해 추상 클래스의 메서드를 호출할 수 있음
		pr.makeSource();
		
		StakeRecipe sr = new StakeRecipe("이현복");
		sr.info();
		sr.grillStake();

	}

}
