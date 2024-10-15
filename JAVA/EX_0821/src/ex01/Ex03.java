package ex01;

import java.util.Random;

/*3. 동전의 개수 구하기
Ex03클래스 생성하기
- 10 ~ 5000사이의 난수를 변수에 담는다.
- 생성된 난수의 1의자리는 반드시 0이 되도록 한다.
- 발생된 난수를 각 동전으로 바꾸면 몇개씩 필요한지 판단하는 코드 작성하기
- 가능한 적은 수의 동전을 사용하도록 한다.
 
예시
4170원
500원 : 8개
100원 : 1개
50원 : 1개
10원 : 2개*/

public class Ex03 {
	public static void main(String[] args) {
		
		int[] coin = {500,100,50,10};
		int money = new Random().nextInt( 500 )+1;
		money *= 10;
		System.out.println("금액 : " + money);

		for(int i = 0; i < coin.length; i++) {
		     int res = money / coin[i];
		     System.out.println( coin[i] + "원"+ res);
		     money %= coin[i];
		}
		
	}}
