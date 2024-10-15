package ex03_string;

import java.util.Scanner;

/*
	 -하이픈포함 주민번호 키보드에서 입력받음
	 -예시)911223-1234567
	 -결과)당신은 1999년 11월에 22일에 태어난 남자입니다
	 -형식잘못입력 -> 주민번호 올바르게 입력하시오
	 */

public class Ex04_String {
	public static void main(String[] args) {
		
	System.out.print("주민번호 입력(하이픈'-'포함) : " );	
	Scanner sc = new Scanner(System.in);
	String id = sc.next();
	
	//잘못 쓴 경우
	if(id.length()<14 || id.charAt(6)!='-') {
		System.out.println("주민번호를 올바르게 입력하세요.");
	}else {
		String year = "";
		String result = "";
		
		year = id.substring(0,2);
		if(Integer.parseInt(year)<=14) {
			result = "당신은 20";
		}else {
			result = "당신은 19";
		}result +=year+"년"+
			id.substring(2,4)+"월"+
			id.substring(4,6)+"일에 태어난 ";
		
		if(id.charAt(7)%2 !=0){
			result +="남자입니다.";
		}else {
			result +="여자입니다.";
		}System.out.println(result);
	}
	
	
		
		
	}
}
