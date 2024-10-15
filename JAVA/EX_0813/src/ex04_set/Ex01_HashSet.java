package ex04_set;

import java.util.HashSet;

public class Ex01_HashSet {
	public static void main(String[] args) {
		
		//HashSet 선언하기
		HashSet<String> hs1 = new HashSet<String>();
		
		//HashSet에 데이터를 추가
		hs1.add("a");
		hs1.add("b");
		hs1.add("f");
		hs1.add("d");
		System.out.println(hs1);	
		

		//set에는 중복된 데이터를 추가할 수 없음
		hs1.add("a");
		hs1.add("b");
		System.out.println("중복추가한 set : "+hs1);

		//set에 저장되어 있는 a라는 데이터 제거
		//index를 지원하지 않기 때문에 순서에 의한 삭제는 지원하지 않음
		hs1.remove("a");
		System.out.println("a제거 : "+hs1);

		//hs1.removeAll(hs1); --> hs1의 모든 index를 제거
		System.out.println("----------------------------------");

	}}
