package ex01_interface;

public  class Won2Dollar extends Converter {
	
	public Won2Dollar(double ratio) {
		this.ratio = ratio;
		}// : Main에 나왔던 Won2Dollar(1200)라는 생성자를 받기위함
	
		/*
		오버라이딩 : 부모의 메서드를 자식클래스의 상황에 맞게 재정의
		-메서드의 시그니처(접근제한자,반환형,메서드명,매개변수)를 그대로 가져가야함
		-메서드 안의 내용만 자식클래스의 상화엥 맞게 재정의해야 함
		 */

	@Override
	protected double converter(double src) {
		
		return src/ratio;
	}

	@Override
	protected String getSrcString() {
		
		return "원";
	}

	@Override
	protected String getDestString() {
		
		return "달러";
	}
	
	

}
