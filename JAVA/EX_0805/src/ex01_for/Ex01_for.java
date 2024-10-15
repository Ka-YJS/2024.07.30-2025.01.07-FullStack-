package ex01_for;

public class Ex01_for {

	public static void main(String[] args) {
		
		
		int[] score = {90,92,93};
		
		
		int sum = 0;
		double avg = 0.0;
		
		
		for(int i : score) { //:score의 요소를 i에 넣음 -> 다음값 넣음 -> 더함 -> 반복
			sum += i;
		}
		
		
		avg = (double)sum/3;
		System.out.println("총점 : " + sum + ", 평균 : " + avg);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
