package ex02_map;

import java.util.HashMap;

public class Ex01_map {
	public static void main(String[] args) {
		
		//map에 데이터 추가하기
		HashMap<Integer , Character> map = new HashMap<Integer , Character>();
		  map.put(1, 'A');	
		  map.put(2, 'B');	
		  map.put(3, 'C'); 
		  map.put(4, 'D');//숫자를 1~5순서대로 썼지만 순서는 아님, 다른 숫자들도 가능
		  System.out.println("map 값 : "+map);
		  // map에 저장되는 value는 중복될 수 있다.
		  
		  
		  //but. key는 불가능
		  map.put(3,'F');
		  System.out.println("map 값(c->f) : "+map);
		  //기존에 같은 이름을 가진 key가 있다면 value를 갱신함
		  
		  //map에서의 삭제는 key값을 통해서 함
		  System.out.println("삭제한 값 : "+map.remove(3));
		  System.out.println(map);
		  
		  //map의 크기
		  System.out.println("map의 크기 : "+map.size());
		 
		  //map에서 특정 value꺼내오기
		  //value를 꺼내올때도 key값 사용
		  char res = map.get(1); //인덱스가 아닌 킷값으로 벨류를 찾는다.
		  System.out.println(res);	
		  
		  //map은 .langth가 아닌 .size()를 사용System.out.println(map);  {1=A , 2=B}	
		  map.put(5, 'A');  //Value값으로 key값을 찾는건 불가능 하다.
		  System.out.println("map 값 : "+map);


	}
}
