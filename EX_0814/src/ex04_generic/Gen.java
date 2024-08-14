package ex04_generic;
	/*
	-Gen클래스를 정의 -> 제네릭 타입T를 갖는 printArr메서드를 생성
	-printArr메서드 내부에서 배열을 순차적으로 보여줄수 있게 하는 코드를 작성
	-GenMain클래스를 작성 -> Integer[], Double[], Character[]을 각각 만든 뒤
	-Gen클래스의 printArr메서드를 각각 호출하여 배열의 내용을 출력
	
	결과 :
		 1 2 3 4 5  //정수배열 출력
		 1.1 2.2 3.3 4.4 5.5 //실수배열 출력
		 A B C D E //문자배열 출력*/

public class Gen <T> {
	
	//제네릭 메서드
	public <T> void printArr(T[] arr){

		for(T i : arr){
			System.out.print(i+" ");
		}
		System.out.println();}

}
