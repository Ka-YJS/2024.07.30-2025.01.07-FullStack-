package ex01_try_catch;

import java.util.Scanner;

	/*
	-나이 입력받음
	-20살 이상 -> 성인, 14살 이상 -> 청소년, 7살이상 -> 어린이
	-그 이외는 아동
	-단, 0이하의 수가 입력되면 InputErrorException을 발생 + 입력잘못
	*/

public class Ex02_try_catch {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("당신의 나이를 입력하세요 >> ");
			int age = sc.nextInt();
			
			if(age < 0) {
				throw new InputErrorException("입력이 잘못되었습니다.");
			}
			
			if(age > 19) {
				System.out.println("성인");
			}else if(age > 13) {
				System.out.println("청소년");
			}else if(age > 6) {
				System.out.println("어린이");
			}else {
				System.out.println("아동");
			}
		} catch (InputErrorException e) {//InputErrorException e말고 Exception e도 가능
			System.out.println(e.getMessage());
		};
		
		
	}

}
