package ex03_method;

import java.util.Arrays;

public class MethodTest {
	/*
	배열의 최대값을 찾아 출력하는 maxFinder메서드 작성하기
	배열은 매개변수로 전달받음
	*/
	
	public void maxFinder(int[]arr) {
		int max = arr[0];
		
		/*
		 * for(int i : arr) { if(i>max) {
		 * 
		 * max=i; } }System.out.println("최대값 : "+max);
		 */
	
	Arrays.sort(arr);//오름차순정렬
	System.out.println("최대값 : "+arr[arr.length-1]);
	
	
	}
	
	/*
	 * Main에서 숫자두개, 산술연산자(문자열) 전달받음 + 계산 -> 반환
	 * getResult()메서드 작성하기
	 */
	
	
	public int getResult(int a, int b,String op) {
		
		//객체 == 객체 : 같은 값을 묻는 것이 아닌 주소 값이 같은지 묻는 것임
		if(op.equals("+")) {
			return a+b;
			
		}else if(op.equals("-")) {
			return a-b;
		
		}else if(op.equals("*")) {
			return a*b;
		
		}else if(op.equals("/")) {
		return a/b;
		
		}else {
			System.out.println("연산기호가 올바르지 않음");
			return -1;
		}
		
	}
	
	
	
	
	

}
