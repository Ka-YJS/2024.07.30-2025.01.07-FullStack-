package ex02_list;

import java.util.ArrayList;
import java.util.List;

public class Ex03_ArrayList {
	public static void main(String[] args) {
		
		/*ArrayList에 데이터 삭제*/

		List<Integer> list = new ArrayList<>();
		
		//리스트에 2의 배수를 10개 넣기
		for(int i=1;i<11;i++) {
			list.add(i*2);
		}System.out.println("2의배수 : "+list);
		
		//3번째 인덱스 내용 삭제
		list.remove(3);
		System.out.println("3번째 인덱스 내용(8) 삭제 : "+list);
		
		//숫자 타입의 데이터는 객체화 후 삭제
		list.remove(Integer.valueOf(10));
		System.out.println("10 삭제 : "+list);
		
		/*
		
		//전체 삭제_객체를 통한 삭제->삭제하고 논리형을 반환 true, false
		list.removeAll(list);
		System.out.println("전체 삭제1 : "+list);
		
		//전체 삭제2 ->반환하는게 없음
		list.clear();
		System.out.println("전체 삭제2 : "+list);

		*/
		
		//온라인 쇼핑몰에서 장바구니 원리
		if(!list.isEmpty()) {
			if(list.removeAll(list)) {//:true가 나옴
				System.out.println("장바구니가 비워졌습니다.");
			}
		}
		
		
		
	}
}
