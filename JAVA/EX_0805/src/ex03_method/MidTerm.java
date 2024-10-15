package ex03_method;

public class MidTerm {
	
	//학생들의 점수가 두개 들어있는 배열을 전달받음 -> 총합을 구하여 반환하는 score메서드 만들기
	//MidTermMain에서 두 학생의 성적을 비교 -> 누가 더 높은지 출력
	
	public int score(int[]scores) {
		
		int total = 0;
		
		/*
		 * for(int i=0;i<scores.length;i++) {
		 * 
		 * total += scores[i];
		 * 
		 * }return total;
		 */
		
		
		for(int i : scores) {
			total += i;
		}return total;
	}
		
	
		
	

}
