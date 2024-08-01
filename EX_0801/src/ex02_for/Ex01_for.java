package ex02_for;

import java.util.Scanner;

public class Ex01_for {

	public static void main(String[] args) {

		for(int i =0;i<3;i++) {
			
			System.out.println(i);
		}
		
		
		System.out.println("---------------");
		
		//1~10출력하기
		
		for(int a=1;a<11;a++) {
			System.out.print(a+" ");
		}
		
		System.out.println("\n---------------");
		
		for(int b=10;b>0;b--) {
			System.out.print(b+" ");
		}
		
		
		System.out.println("\n---------------");
		
		//1~20 홀수만 가로로 출력
		
		for(int n=1;n<=20;n++) {
			if(n%2==1) {
				System.out.print(n+" ");
			}
		}
		
		System.out.println("\n---------------");
		
		//1~10 3의 배수
		
		for(int k=1;k<=10;k++) {
			if(k%3==0) {
				System.out.print(k+" ");
			}
		}
		
		
		System.out.println("\n---------------");
		
		//1~10까지 총합
		
		int sum=0;
		
		for(int i=0;i<=10;i++) {
				sum += i;
		}System.out.println(sum);
		
		
		System.out.println("---------------");
		
		
		//정수형 변수 dan에 2~9사이의 값으로 초기화 -> dan에 해당하는 구구단 출력
		//2 x 2 = 2
		
		
		int dan = 0;
		
		for(int i=1;i<=9;i++) {
			
				dan +=i;
			
			for(int j=1;j<=9;j++) {
				dan +=j;
			
				System.out.print(i+" X " + j + " = " + i*j + "\n");
			}
		}
		
		System.out.println("---------------");
		
		//키보드에서 정수를 하나 입력받음 -> 1부터 입력받은 수까지의 총합 구하기
		
		
		/*
		Scanner sc = new Scanner(System.in);

		System.out.print("정수입력 : ");
		int num = sc.nextInt();
	
		int total = 0;
		
		for(int i=0;i<=num;i++) {
			total += i;
		}System.out.println(total);
		
		
		System.out.println("---------------");
		*/
		
		
		//10개의 정수를 입력받아 그 중에 짝수가 몇개인지 개수를 출력
		
		/*
		 * 
		Scanner scan = new Scanner(System.in);
		
		int count=0;
		
		for(int i=0;i<10;i++) {
			
			System.out.print("정수입력 : ");
			int number = scan.nextInt();
		
			
					if(number%2==0) {
						
						count++;
						
						
					}
		
		}System.out.print("짝수의 개수 : "+count);
		
		*/
		
		
		System.out.println("---------------");
		
		//키보드로 정수 2개 입력받음 -> x~y까지 총합출력
		//->ex)2,3->2+3+4+5=14
		//->단, x가 y보다 큰 경우 x와y를 바꿔서 총합구하기
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("x입력 : ");
		int x = scan.nextInt();
		System.out.print("y입력 : ");
		int y = scan.nextInt();
	
		if(x>y) {
				int z = x;
				x=y;
				y=z;}
				
		sum=0;
		for(int i=x;i<=y;i++) {	
			sum +=i;
			}
		System.out.printf("%d부터 %d까지의 총합 : %d",x,y,sum);
		
		
		
		
		
		
		
		
	}

}
