package ex05_abstrarct;

public class StakeRecipe extends Recipe {
	
	public StakeRecipe(String chef) {
		super(chef);
	}

	void grillStake() {
		System.out.println("스테이크를 맛있게 굽습니다.");
	}

}
