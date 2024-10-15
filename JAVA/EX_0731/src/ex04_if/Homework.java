package ex04_if;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		
		
		//숙제) 삼항연산자로 만들었던 X개의 농구공을 담기위한 박스의 개수 구하기 -> 조건문으로 만들기

		int ball = 23;
		int n = 5;
		int box = 0;

		
		if(ball % n == 0) {
			box = ball/n;
			
		}else {box = ball/n+1;}
		
		System.out.println("필요한 박스의 개수 : "+box);
		
		
		System.out.println("======================");
		
		
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.print("공의 개수 입력 : ");
		
		int ball = sc.nextInt();
		int n = sc.nextInt();
		int box = 0;
		
		
		if(ball % n == 0) {
			box = ball/n;
			
		}else {box = ball/n+1;}
		
		System.out.println("필요한 박스의 개수 : "+box);
		
		*/
		
		
		

	}

}
