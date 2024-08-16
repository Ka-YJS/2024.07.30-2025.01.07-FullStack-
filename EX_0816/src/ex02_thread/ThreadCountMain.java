package ex02_thread;

import java.util.Scanner;

	/*문제1)
	1. 스캐너를 통해 숫자 입력받음
	2. 스레드에서 입력받은 숫자부터 1씩 감소하다가 0이 되었을 때 "종료"라는 메시지와 함께 종료
	3. ThreadCount 클래스에 스레드 정의하기
	*/

public class ThreadCountMain {
	public static void main(String[] args) {
	
		System.out.print("값을 입력 : ");
		Scanner sc = new Scanner(System.in);
		
		ThreadCount t = new ThreadCount(sc.nextInt());
		Thread tc = new Thread(t);
		tc.start();
		
	}}
