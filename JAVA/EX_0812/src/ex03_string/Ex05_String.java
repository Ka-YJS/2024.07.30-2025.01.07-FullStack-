package ex03_string;

import java.util.Scanner;

	 /*
	 -문자열 s의 길이가 4 또는 6이고, 숫자로만 구성되어있는지 확인하는 코드
	 -문자열s는 키보드에서 입력받음
	 -a234=false, 1234=true
	 -제한사항 : s는 길이 1~8문자열, 영문알파벳 대소문자 또는 0~9로 이루어짐
	 */

public class Ex05_String {
	public static void main(String[] args) {
		
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println("결과 : "+solution(s));
		
		
	}

public static boolean solution(String s) {
		
		//길이가 4 또는 6인지 판별
		if(s.length()==4 || s.length()==6) {
			//요소가 전부 숫자인지 판별
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)<48 || s.charAt(i)>57) {
					return false;//길이가 4or6 + 숫자가 아닌 것
				}
			}return true;//길이가 4or6 + 전부 숫자
		}else {
			return false;//길이가 4or6가 아닌 것
		}
		
		/*다른풀이1)try-catch
			
		if(s.length()==4 || s.length()==6) {
			try {
				int n= Integer.parseInt(s);//Integer.parseInt : 인자로 전달된 문자열을 정수로 바꿈
				return true;
			} catch (Exception e) {
				return false;
			}
			} return false;
		}
		*/
		
		/*다른풀이2)자바스크립트이용
		
      if(s.length() == 4 || s.length() == 6) {
         return s.matches("(^[0-9]*$)");
      } return false;   
		 */
		
	
		
		
	}
}
