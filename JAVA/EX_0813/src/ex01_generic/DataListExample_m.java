package ex01_generic;

//Generic사용해서 코드수정
public class DataListExample_m {
	public static void main(String[] args) {
		
		DataList_m<Integer> list = new DataList_m<Integer>();
		/* Generic 타입은 기본자료형을 인식하지 않음
		따라서 int, double 등의 기본자료형을 제네릭타입으로 이용하려면
		Integer, Double 등의 Wrapper클래스를 이용해야 함 */
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		/*
		 * list.add("문자열");
		 * 
		 * list.add(13.45);
		 * 
		 * list.add('B'); -> Integer를 사용해서 이 3개는 더이상 쓸 수 없음
		 */
		
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			
			sum +=list.get(i);
	}System.out.println("총합 : "+sum);
	
	
}}
