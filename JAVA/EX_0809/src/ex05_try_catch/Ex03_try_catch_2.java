package ex05_try_catch;

import java.util.Scanner;

    /*

	문제1) 추가 -> 수정
		입력 : aaa
		결과 : aaa는(은) 정수가 아닙니다.
		
	*/

public class Ex03_try_catch_2 {
	public static void main(String[] args) {
		
		System.out.print("정수입력 : ");
		Scanner sc= new Scanner(System.in);
		String str = "";
		
		try {
			int n = sc.nextInt();
			str = sc.next();
			int num = Integer.parseInt(str);
			System.out.println("결과 : " + num);
		} catch (Exception e) {
			String name = sc.nextLine();
			System.out.println(name + "은(는) 정수가 아닙니다.");
		}	


	}

}

/*
	선생님 답 : 
		
		public class Ex04_try_catch {
		public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String num = "";
		
		try {
			System.out.print("정수입력 : ");
			num = sc.nextInt();
			int n = Integer.parseInt(num);//예외발생 가능성 있음
			System.out.println("입력받은 수 : "+n);
			
		} catch (Exception e) { 
			System.out.println(num+"는(은) 정수가 아닙니다.");
		}
		
		System.out.println("프로그램 종료");
		
		}

		}
		
		*/

