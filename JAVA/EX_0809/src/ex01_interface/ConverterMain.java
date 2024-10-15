package ex01_interface;
	/*문제1)
	 -Converter클래스를 상속받아 원화->달러로 바꾸는 Won2Doller클래스 작성
	 -실행결과 : 
	 원을 달러로 바꿉니다.
	 원을 입력 -> 24000
	 변환결과 : 20.0달러
	 */


public class ConverterMain {
	public static void main(String[] args) {
		
		   //메인실행결과는 아래와 같음 : 
		   Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원 -> 1375...
		   								//->생성자의 호출
		   toDollar.run();
		
		

	}

}
