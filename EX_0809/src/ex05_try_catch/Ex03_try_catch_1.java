package ex05_try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

/*

	문제1)
	-키보드에서 정수 입력받음 -> 정수 이외의 값 입력되면 "정수만 입력가능" 출력
	-결과 : 
		정수 : 100
		입력받은 수 : 100
		
		정수 : aaa
		결과 : 정수만 입력가능
		
	*/

public class Ex03_try_catch_1 {
	public static void main(String[] args) {
		
		System.out.print("정수입력 : ");
		Scanner sc = new Scanner(System.in);
		
		try {
			int num = sc.nextInt();
			System.out.println("입력받은 수 : "+num);
			
		} catch (InputMismatchException e) { 
			System.out.println("정수만 입력가능");
		}
		
		System.out.println("프로그램 종료");
		
		
		


	}

}

/*선생님 답 : 
 
 
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("정수입력 : ");
			int num = sc.nextInt();
			System.out.println("입력받은 수 : "+num);
			
		} catch (exception e) { 
			System.out.println("정수만 입력가능");
		}
		
		System.out.println("프로그램 종료");
 
 
 */
