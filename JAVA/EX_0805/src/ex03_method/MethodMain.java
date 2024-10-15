package ex03_method;

import java.util.Scanner;

public class MethodMain {

	public static void main(String[] args) {
		
		MethodTest mt = new MethodTest();
		
		int[]arr = {4,5,1,2,9,10};
		
		mt.maxFinder(arr);
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.println("두번째 숫자 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.println("연산기호 입력 : ");
		String op = sc.next();
		
		int result = mt.getResult(num1,num2,op);
		System.out.println("결과 : "+result);
		

	}

}
