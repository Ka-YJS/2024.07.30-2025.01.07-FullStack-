package ex03_string;

import java.util.Scanner;

/*
	 -회문판별하기
	 -회문 : 앞으로 읽어도 뒤로 읽어도 똑같이 읽히는 문장
	 -ex.기러기 토마토 별똥별 스위스
	 -키보드에서 문장 입력받음 -> 회문이면 ~는 회문입니다, 아니면 ~은 회문이 아닙니다 출력
	 */

public class Ex03_String {
	public static void main(String[] args) {
		
	System.out.print("회문입력 : ");
	Scanner sc = new Scanner(System.in);
	
	String ori = sc.next();//원본을 입력받음
	String rev = "";//뒤집어서 담기위한 문자열변수
	
	for(int i= ori.length();i>0;i--) {
		rev+=ori.charAt(i-1);
	}
	if(ori.equals(rev)) {
		System.out.println(ori+"은(는) 회문입니다.");
	}else {System.out.println(ori+"은(는) 회문이 아닙니다.");}

	
	
		
		
	}
}
