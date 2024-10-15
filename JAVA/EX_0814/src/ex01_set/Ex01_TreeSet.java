package ex01_set;

import java.util.Arrays;
import java.util.TreeSet;

public class Ex01_TreeSet {
	public static void main(String[] args) {
		
		TreeSet<Integer> set1 = new TreeSet<>();//TreeSet 객체 생성
		TreeSet<Integer> set2 = new TreeSet<Integer>(set1);//set1의 모든 값을 가진 TreeSet생성
		//초기값을 가지고 만들어지는 TreeSet객체
		TreeSet<Integer> set3 = new TreeSet<Integer>(Arrays.asList(1,2,3));

		TreeSet<Integer> set = new TreeSet<Integer>();//비어있는 TreeSet생성

		//TreeSet에 값 추가하기
		set.add(7);
		set.add(4);
		set.add(9);
		set.add(1);
		set.add(5);
		
		System.out.println("값 추가 : "+set);
		
		//TreeSet값 삭제
		set.remove(1);//값 1 제거
		System.out.println("값 제거 : "+set);
		set.clear();//모든 값 제거
		System.out.println("모든 값 제거 : "+set);
		
		//TreeSet크기 구하기
		TreeSet<Integer> set4 = new TreeSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,9));//초기값 지정
		System.out.println("크기구하기 : "+set4.size());
		
		//Tree에 값 출력하기
		System.out.println(set4); //전체출력
		System.out.println("최소값 : "+set4.first());//최소값 찾아서 반환 및 출력
		System.out.println("최대값 : "+set4.last());//최대값 찾아서 반환 및 출력
		System.out.println("큰값 중에 작은 값 : "+set4.higher(3));//입력값보다 큰 데이터중 최소값 출력 없으면 null
		System.out.println("작은값 중에 큰 값 : "+set4.lower(3));//입력값보다 작은 데이터중 최대값 출력 없으면 null

		/*
		
		//index가 없기 때문에 요소를 하나씩 꺼낼 수가 없음
		//단, Iterator을 사용하면 하나씩 꺼낼 수 있음
		// Iterator 사용
		TreeSet<Integer> iter = new TreeSet<Integer>();	
		//hasNext( ) : 다음에 순회할 요소가 있으면 true, 없으면 false
		while(iter.hasNext()) {
		//다음 요소를 반환함	
			int val = iter.next();
			System.out.println(val+" ");
		}*/

		
	}}
