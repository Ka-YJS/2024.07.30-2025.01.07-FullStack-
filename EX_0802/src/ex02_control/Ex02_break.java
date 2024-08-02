package ex02_control;

import java.util.Scanner;

public class Ex02_break {

	public static void main(String[] args) {
		
		//break사용
		
		int magicNumber = (int)(Math.random() * 50) + 1;
		//random() : 0.0~0.1숫자를 랜덤으로 생성
		Scanner scan = new Scanner(System.in);
		boolean isMatched = false;
		//isMatched 사용한 이유 : 정답을 못 맞춘 경우에 그 내용을 출력하기위해서
		
		System.out.println("답 : " + magicNumber);
		
		for(int i = 0 ; i < 10; i++) {
			System.out.print("찾는 숫자를 입력 : ");
			int guess = scan.nextInt();
			
			if(guess == magicNumber) {
				System.out.println((i+1) + "번째에 맞췄습니다!");
				isMatched = true;
				break;
			} else if(guess > magicNumber) {
				System.out.println("DOWN!");
			} else if(guess < magicNumber) {
				System.out.println("UP!");
			}
		}
		
		if(!isMatched) {
			System.out.println("정답을 맞추지 못했습니다.");
		}
		
		
		
		System.out.println("=============");
		
		
		
		for(int i=1;i<=3;i++) {
			for(int j=1;j<=5;j++) {
				if(j%2==0) {
					continue; //break로도 바꿔보기
				}
				System.out.println(j+" ");
				
			}System.out.println();
		}
		
		
		System.out.println("=============");
		
		//라벨을 이용하면 내가 원하는 반복문에 적용시킬 수 있음(위에꺼활용)
		
		happy : for(int i=1;i<=3;i++) {
					for(int j=1;j<=5;j++) {
						if(j%2==0) {
							break happy;//for문이 멈춤
						}
						System.out.println(j+" ");
						
					}System.out.println();
				}

	}

}
