package ex05_try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex04_try_catch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int [ ] cards = {4,5,1,2,7,8};
			System.out.print("몇 번째 카드를 뽑으시겠습니까? >>");
			
			int cardIndex = sc.nextInt();
			System.out.println("뽑은 카드 번호는 : " + cards[cardIndex]);
			
		} catch (InputMismatchException e) { 
			//Exception e 만 넣으면 모든 예외처리는 가능하나 두개를 한꺼번에 받을 수는 없음
			System.out.println("정수를 입력해주세요.");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 번호의 카드는 없습니다.");
		}
		
		System.out.println("프로그램 종료");

	}
}
