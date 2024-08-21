package ex04;

import java.util.ArrayList;
import java.util.Scanner;

/*  - User객체를 가지는 ArrayList 생성하기
    - 유저의 정보를 입력받아 ArrayList에 저장하기
    - 다음과 같은 결과가 나오도록 코드를 작성하시오
    - 아이디가 중복될경우 “아이디가 중복됩니다”라는 메세지를 출력하고 다시 입력받는다.
    - 출력결과 : 
    아이디 생성 : aaa
	패스워드 입력 : 1234
	
	aaa
	1234
	------------------------
	아이디 생성 : bbb
	패스워드 입력 : 5678
	
	aaa
	1234
	------------------------
	bbb
	5678
	------------------------
	아이디 생성 : 
    
    */

public class UserMain {
	public static void main(String[] args) {
		
		ArrayList<UserInfo> arr = new ArrayList<UserInfo>();

		while(true){
			
			System.out.print("생성할 아이디 입력 : ");		
			Scanner scan1 = new Scanner(System.in);
			
			UserInfo ui = new UserInfo();
			ui.setId(scan1.next());

			System.out.print("패스워드 입력 : ");
			Scanner scan2 = new Scanner(System.in);
			ui.setPwd(scan2.nextInt());
			
			//중복부분이 계속 오류가......
			
			
			for(int i = 0; i < arr.size(); i++){
				System.out.println(arr.get(i).getId());
				System.out.println(arr.get(i).getPwd());
				System.out.println("------------------------");
			}}
		

	}}
