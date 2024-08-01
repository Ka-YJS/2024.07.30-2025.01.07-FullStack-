package ex01_switch;

import java.util.Scanner;

public class Ex05_switch {

	public static void main(String[] args) {
		
		
		//문제1)10이하의 숫자를 키보드에 입력받음
		//-해당 숫자가 짝수/홀수 판별코드->switch

		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		
		int num = sc.nextInt();
		
		switch(num%2) {
		
		case 1 : 
			System.out.println("홀수");
		 	break;
		case 0 : 
			System.out.println("짝수");
		 	break;
		default : System.out.println("잘못입력");
		 	break;
		}
		
		
		System.out.println("====================");
		
		//문제2)달(month)를 입력받아 해당 달이 며칠까지있는지 switch문 이용해서 작성
		//결과 : 0월은 00일까지 있습니다.
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("달(month)입력 : ");
		
		int month = scan.nextInt();
		int day=0;
		
		switch(month) {
		
		case 1,3,5,7,8,10,12 -> day=31;
		case 2 -> day=28;
		case 4,6,9,11 -> day=30;
		
		default -> System.out.println("잘못된 입력");
		
		
		}System.out.printf("%d월은 %d일까지 있습니다.",month,day);
		
		
		System.out.println("====================");
		
		//계산기프로그램 : 두개의 정수를 입력받음
		//->산술연산자를 문자열에 담음, switch문사용, 정수연산코드사용
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("숫자1 입력 : ");
		int num1 = s.nextInt();
		System.out.print("숫자2 입력 : ");
		int num2 = s.nextInt();
		System.out.println("산술 연산자 입력 : ");
		String op = s.next();

		
		switch(op) {
		
		case "+" ->	System.out.printf("%d+%d=%d\n",num1,num2,(num1+num2));
		case "-" ->	System.out.printf("%d-%d=%d\n",num1,num2,(num1-num2));
		case "*" ->	System.out.printf("%d*%d=%d\n",num1,num2,(num1*num2));
		//수학적인 나눈기를 하려면 숫자 하나를 double 로 형변환
		case "/" ->	System.out.printf("%d/%f=%f\n",num1,num2,(num1/(double)num2));
		
		
		}
		
		
		

	}

}
