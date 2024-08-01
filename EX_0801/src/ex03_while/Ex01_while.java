package ex03_while;

import java.util.Scanner;

public class Ex01_while {

	public static void main(String[] args) {
		
		
		int num = 1;
		
		while(num <= 10){ 
			System.out.println(num);
			num++;}
		
		System.out.println("---------------------------");
		
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		while(n !=-1) {
			System.out.print("정수 입력 : ");
			n = sc.nextInt();
			System.out.println("입력된 정수"+n);}
		
		
		System.out.println("---------------------------");
		
		
		//각 자리수의 합 구하기
		//정수형 변수n이 있을 때, 각 자리의 합을 더한 결과를 출력
		//n의 값이 12345라면 1+2+3+4+5의 결과인 15를 출력
		//n의 값은 키보드에서 받기
		
		Scanner scan = new Scanner(System.in);

		System.out.print("정수 입력 : ");
		int num1 = scan.nextInt();
		
		int sum = 0;
		
		while(num1>0) {
			sum += num1%10;
			num1=num1/10;
		}System.out.println("각 자리수의 합 : "+sum);
		
		
		System.out.println("---------------------------");
		
		
		//두개의 주사위를 던졌을 때 눈의 합이 6이 되는 경우의 수
		
		
	int x = 1;
		
	while(x<=6) {
		
		int y = 1;
		while(y<=6) {
		
			if(x+y==6) {
				System.out.println(x+","+y);
			}y++;
		}x++;
		
	}
		
		
		


	
	
	}
}


