package ex04_set;

import java.util.HashSet;
import java.util.Random;

public class Ex02_HashSet {
	public static void main(String[] args) {
		
		//순서가 없음, 중복되는 값이 안들어감
		//HashSet을 선언한 후 1~45사이의 난수 생성하여 로또번호 뽑기
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(true) {
			//1~45사이의 난수를 뽑음
		      int r = new Random().nextInt(45) + 1;
		    //HashSet에 추가함  
		      hs.add(r);

		   //배열이 아니기 때문에 모든 컬렉션 개체는 size()라고 하는 메서드로 방의 개수를 파악
		     if( hs.size() == 6 ) { //size() : set객체의 방 개수
		               break;
		     }//while 단점 배열처럼 인덱스 번호가 없음, 하나를 골라서 지울수 없음

		     System.out.println(hs);
		    
		//Set -> 배열 형태로 변환
	  //new Integer[0] -> 배열의 방 개수를 0으로 잡으면 set이 add해둔 방 개수만큼 자동으로 배열의 index가 생성됨
		     Integer[] arr = hs.toArray( new Integer[0]);
		     for(int i = 0; i< arr.length; i++) {
		        System.out.println(arr[i] + " ");
		    }}
		
		
		

	}}
