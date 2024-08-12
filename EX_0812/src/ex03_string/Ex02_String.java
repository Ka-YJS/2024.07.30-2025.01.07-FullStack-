package ex03_string;

import java.util.Scanner;

	/*
	 -키보드에서 숫자와 특수문자를 제외한 알파벳을 무작위로 입력받음
	 -입력받은 문자열에 소문자 a가 몇 개 있는지를 판별하는 코드 작성
	 -결과
	 	입력 : asdfasdf
	 	a의 개수 : 2
	 */

public class Ex02_String {
	public static void main(String[] args) {
		
		System.out.print("알파벳 입력 : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int count = 0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a') {
				count++;
			}
		}System.out.println("a의 개수 : "+count);
		
		
	}
}
