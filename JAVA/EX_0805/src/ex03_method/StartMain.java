package ex03_method;

import java.util.Scanner;

public class StartMain {

	public static void main(String[] args) {
		
		Start s = new Start();
		
		Scanner sc = new Scanner(System.in);
		
		//:정답을 맞출때까지 반복 -> for?while? -> 몇번째일지 모름 -> while 택
		
		while(true) {
			System.out.print("숫자 입력 : ");
			
			int number = sc.nextInt();//:숫자 입력받음
			
			if(s.check(number).equals("정답!")) {
				System.out.println("정답입니다.");//:난수를 맞추면 반복문 나가기
				System.out.println(s.count+"회 만에 맞추셨습니다.");
				break;
			}else {
				System.out.println(s.check(number));
				s.count++; //:틀릴때마다 카운트가 증가
			}
		}
		
		
		

	}

}
