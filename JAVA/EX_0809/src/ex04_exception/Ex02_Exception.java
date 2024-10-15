package ex04_exception;

public class Ex02_Exception {
	public static void main(String[] args) {
		
	//2번 예외 : 	NumberForamtException
		
		String str01 = "11";
		String str02 = "11.2";
		
		
		int num01 = Integer.parseInt(str01);//정수 형태의 문자열을 정수로 변환 -> 출력가능
		System.out.println("String to int : " + num01);
		
		int num02 = Integer.parseInt(str02);//실수 형태의 문자열을 정수로 변환 -> 출력불가능
		System.out.println("String to int : " + num02);
		
		//->숫자형태("111")은 정수로 변환할 수 있지만, "11.11"은 변환할 수 없음

	}

}
