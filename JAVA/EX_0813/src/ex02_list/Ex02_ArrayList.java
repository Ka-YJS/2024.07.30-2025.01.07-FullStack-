package ex02_list;

import java.util.ArrayList;
import java.util.List;

public class Ex02_ArrayList {
	public static void main(String[] args) {
		
		/*ArrayList에 데이터 치환(수정)*/

		//리스트 선언
		List<String> list = new ArrayList<>();
		//==ArrayList<String>list = new ArrayList<>();
		
		//데이터삽입
		list.add("딸기");
		list.add("복숭아");
		list.add("망고");
		
		//리스트 출력
		System.out.println("리스트 내용1 : " + list);

		// 데이터 변환
		list.set(0,"사과");
		list.set(1, "수박");

		System.out.println("리스트 내용2 : " + list);
		
		
	}
}
