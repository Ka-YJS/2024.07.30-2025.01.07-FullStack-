package ex03_array;

import java.util.Random;
import java.util.Scanner;

public class Ex04_Array {

	public static void main(String[] args) {
		
		//문제1)
		//10개정수 담는 배열생성 , 배열에 Random클래스이용 1~30난수넣기
		//nextInt(30)+1;, 모든요소출력(가로), 짝수합
		
		
		Scanner sc = new Scanner(System.in);
		
		int [] numbers = new int [10]; //배열생성
		
		Random rnd = new Random();
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = rnd.nextInt(30)+1;//random클래스 적용
			
		}
		for(int i=0;i<numbers.length;i++) {
			System.out.print(numbers[i]+" ");//난수 출력
		}

		System.out.println();
		
		int sum = 0;
		for(int i =0;i<numbers.length;i++) {
			if(numbers[i]%2 ==0) {
				sum += numbers[i];
			}
		}System.out.println("짝수의 합 : "+ sum);//짝수의 합
		
		
		System.out.println("=================================");
		
		
		//문제2)
		//배열에서 영문자만 추출하여 이어붙여 출력 -> 출력결과 : LOVE

		char [] cards = {'1','L','2','O','3','V','E','4'};
		String myWord = "";
		
		//배열의 전체를 순회하는 반복문
		for(int i = 0;i<cards.length;i++) {
			if(cards[i]>='A' && cards[i] <='Z') {
				myWord += cards[i]; //:myWord = ""+cards[i];
			}
		}System.out.println("단어 : " + myWord);
		
		
		System.out.println("=================================");
		
		
		//문제3)
		//배열 arr에 담겨있는 모든 값의 합을 구하시오
		
		int [] arr = {10,20,30,40,50};
		sum = 0; //위에서 sum을 이미 사용했으므로 0으로 값을 초기화시킨 후에 다시 진행
				//같은 이름의 변수를 다시 선언할 수 없으므로 int sum = 0;는 사용할 수 없음
		
		for(int i = 0;i<arr.length;i++) {
			
			sum +=arr[i];
					
		}System.out.println("총합 : "+sum);
		
		
		System.out.println("=================================");
		
		
		/*
		문제5)
		다음 조건에 맞는 문제를 푸시오
		키보드에서 배열의 길이를 입력받음 -> 입력받은 길이만큼 알파벳 넣고 출력
		ex.배열의 길이를 입력하세요 : 5 -> abcde */

		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("배열의 길이 : ");
		char [] c = new char[scn.nextInt()]; //배열의 길이 입력받음
		
		char c1 = 'A'; //char에 변수 c1입력
		
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]=c1++);
		}
		
		
		System.out.println("=================================");
		
	
		/*
		문제6)
		동전의 개수 구하기
		1의자리는 반드시 0이 되어야 함 
		발생한 난수를 각 동전으로 바꾸면 몇개씩 필요한지 판단하는 코드작성 
		가능한 적은 수의 동전을 사용하도록 함 
		ex)4170원 : 500*8,100*1,50*1,10*21 */
		
		int [] coin = {500,100,50,10};
		
		//난수에는 1의 자리가 없어야 함
		int money = (rnd.nextInt(500)+1)*10;//일의자리*10
		System.out.println("돈 : "+money);
		
		for(int i=0;i<coin.length;i++) {
			//4170원으로 가정
			int res = money/coin[i]; //동전의 개수
			money %=coin[i];
			//윗줄과 같음 : money = money % coin [i] //잔돈
			System.out.printf("%d원 : %d개 \n",coin[i],res);	
			
		}
		
		System.out.println("=================================");
		
		/*
		문제7)
		로또번호 생성하기
		1~45 난수발생 로또번호 배열저장 -> 출력*/
		
		int [] lotto = new int[6];
		
		outer : for(int i=0;i<lotto.length;) {
			lotto[i] = rnd.nextInt(45)+1;
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					continue outer;
				}
			}//inner
			
			System.out.print(lotto[i]+"  ");
			i++;
		}


	}

}
