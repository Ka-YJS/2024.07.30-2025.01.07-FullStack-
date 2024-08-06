package ex02_constructor;

public class Snack {
	
	int price;
	
	/*
	public Snack() {//:기본생성자
					//:안에는 텅 비어있음
	}
	*/
	
	public Snack(int p) {
		price = p;//:전달하고자하는 값이 있을 때는 반드시 정의해줘야 함
	}
	
	void info() {
		System.out.println("과자의 가격은 " + price + "원입니다.");
	}

}
