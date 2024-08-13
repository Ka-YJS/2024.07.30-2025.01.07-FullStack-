package ex02_list;

import java.util.ArrayList;
import java.util.List;

public class Ex04_ArrayList {
	public static void main(String[] args) {
		
		/*ArrayList에 데이터 얻기*/

		List<Integer> list = new ArrayList<>();
		
		//1~30사이의 난수 10개 리스트에 추가
		for(int i = 0; i < 10; i++) {
			list.add((int)(Math.random() * 30)+1);
		}
		
		//List에 담긴 데이터 중 짝수만 출력
		System.out.print("짝수 : ");
		for(int i = 0; i < list.size(); i++) {
			//List에서 각 index에 위치하는 값 가져오기
			int value = list.get(i);
			if(value % 2 == 0) {
				System.out.print(value+" ");}
	}
		//향상된 for문을 통해서 출력 가능
		for(int value : list) { //:짝수홀수 상관없이 10개출력
			System.out.println("값 : "+value);
		}
		
	
	/*	
	추가 add( );
	조회 get( );
	삭제 remove( );
	수정 set( );
	공백 isEmpty( );
	크기 size( );
	포함 contains( );
	
	+
	-배열의 크기 : 배열명.length
	-문자열의 크기 : 문자열.length( )
	-컬렉션의 크기 : 컬렉션객체.size( )
	*/
	
		
}}
