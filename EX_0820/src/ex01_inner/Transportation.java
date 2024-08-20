package ex01_inner;

public enum Transportation {
	
	//추상메서드가 정의되면 각각 상수객체에서 구현(오버라이딩)해야 함
	BUS(100){
		@Override
		int totalFare(int distance) {
			return distance*fare;
		}
	},
	TRAIN(150){@Override
	int totalFare(int distance) {
		return distance*fare;
	}},
	SHIP(200){
		@Override
		int totalFare(int distance) {
			return distance*fare;
		}
	},
	AIRPLANE(250){
		@Override
		int totalFare(int distance) {
			return distance*fare;
		}
	};
	
	//열거형 상수객체로부터 전달받은 값을 필드에 전달
	protected final int fare;
	
	private Transportation(int fare) {
		this.fare = fare;
	}
	abstract int totalFare(int distance); 
	//열거형에는 추상메서드가 들어갈 수 있음
	
	
	
	
	
	

}
