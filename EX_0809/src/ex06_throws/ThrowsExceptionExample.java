package ex06_throws;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsExceptionExample {
	
	//성격 유형 검사를 위한 메서드
	public static void checkYourSelf(Scanner sc) throws InputMismatchException {
		System.out.println("1. 사람과 어울리는 것이 좋다. 2. 혼자 있는 것이 좋다.");
		System.out.print("선택 : ");
		int check = sc.nextInt();
		
		//성격 체크 후 출력
		if(check == 1) {
			System.out.println("당신은 E");
		}else if(check ==2){
		//이전 입력 값  : 	else {			System.out.println("당신은 I");
			System.out.println("당신은 I");}
		//:3이나 4입력해도 I가 나옴 -> else보단 else if로 경우의 수 나눠주기
		}
	
	
	
	//출력 : 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("==== 성격 유형 검사를 시작합니다. ====");
			
			//메서드 호출
			ThrowsExceptionExample.checkYourSelf(sc);
			
		} catch (InputMismatchException e) {
			System.out.println("키보드 입력이 잘못되었습니다.");
		} finally {
			System.out.println("프로그램 종료");
		}
	}

}
