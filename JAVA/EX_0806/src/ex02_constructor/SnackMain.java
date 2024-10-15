package ex02_constructor;

public class SnackMain {

	public static void main(String[] args) {
		
	//	Snack chip = new Snack(); //객체 생성 및 초기화 -> 생성자 호출
		Snack chip = new Snack(5000);
		
		chip.price = 2000; //객체 필드 설정
		
		chip.info(); //객체 메서드 호출
		
		//객체마다 필요한 정보가 다를 때 생성자를  통해서 데이터를 전달받으면 객체를 생성하는 것이 더 효율적일 수 있음
		Snack potatoChip = new Snack(2000);
		Snack popcorn = new Snack(1800);
		
		//일반적인 메서드와 마찬가지로 매개변수를 두개 이상 설정할 수 있음
		
	}

}
