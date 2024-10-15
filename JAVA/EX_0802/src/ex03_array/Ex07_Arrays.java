package ex03_array;

import java.util.Arrays;

public class Ex07_Arrays {

	public static void main(String[] args) {
		
		//배열의 얕은 복사
		
		int[] arr01 = {1,2,3};//:배열의 주소를 저장
		
		int[] arr02 = arr01;//:얕은복사를 함 -> arr01과 arr02가 같은 주소값을 사용
		
		System.out.println("arr01 배열 : " + Arrays.toString(arr01));
		
		//배열 arr02의 값 변경
		arr02[1] = 10;
		
		//arr01변경 후 배열 출력
		System.out.println("arr01 배열 : " + Arrays.toString(arr01));
		System.out.println("arr02 배열 : " + Arrays.toString(arr02));	
		
		
		System.out.println("======================================");
		
		int [] cards = {1,6,4,5,3,2};
		int [] newCards = new int[cards.length];
		
		//1.Arrays클래스를 이용한 깊은 복사
		int [] newCards2 = Arrays.copyOf(cards, cards.length);
		
		//2.반복문을 이용한 깊은 복사
		for(int i =0; i < cards.length; i++) {
			newCards[i] = cards[i];}

		//3.System클래스를 이용한 깊은 복사
		int[] newCards3 = new int[cards.length];

		System.arraycopy(cards, 0, newCards3, 0, cards.length);
		
		newCards[1] = 100;
		
		System.out.println("cards 배열 : " + Arrays.toString(cards));
		System.out.println("newCards 배열 : " + Arrays.toString(newCards));
		System.out.println("newCards2 배열 : " + Arrays.toString(newCards2));
		System.out.println("newCards3 배열 : " + Arrays.toString(newCards3));
		
		
		

	}

}
