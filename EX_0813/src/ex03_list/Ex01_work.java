package ex03_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex01_work {
	public static void main(String[] args) {
		/*
	
		-아이디생성 : abc -> abc
		-아이디생성 : abc2 -> abc abc2
		-아이디생성 : abc3 -> abc abc2 abc3
		-리스트 요소의 개수가 4개면 프로그램 종료
		
		ArrayList<String>list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			list.add(id);
			System.out.println(list);
	     	System.out.println("--------------------");
	     	
	     	if(list.size()==4) {
	     		break;}
		}*/
		
		//추가)위문제 + 중복된 아이디추가x
		//아이디생성 : abc3 -> abc abc2 abc3
		
		ArrayList<String>list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
outer : while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.next();
			list.add(id);
			System.out.println(list);
	     	System.out.println("--------------------");
	     	
	     	//리스트에 중복이 되는 아이디가 있는지 검증
	    	/*
	     	for(int i = 0; i < list.size(); i++){	           
	    		if(id.equals( list.get(i) )){	                
	    			System.out.println("중복된 아이디");
	    		        continue outer;	
	       		  }
	    	}*/
	    	
	    	if(list.contains(id)) {
	    		System.out.println("중복된 아이디");
	    		continue;
	    	}
	    	list.add(id);

	    	System.out.println(list);
	    	System.out.println("-----------------------");
	    	
	    	if(list.size()==4) {
	    		break;
	    	}
	     			
	     		}
	     	
		
		
	     	}

}
