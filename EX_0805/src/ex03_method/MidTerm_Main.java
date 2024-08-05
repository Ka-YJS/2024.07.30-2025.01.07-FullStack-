package ex03_method;

public class MidTerm_Main {

	public static void main(String[] args) {
		
		int[]student1 = {80,70};
		int[]student2 = {60,50};
		
		MidTerm mid = new MidTerm();
		
		int total1=mid.score(student1);
		int total2=mid.score(student2);
		
		
		if(total1 > total2) {
			System.out.println("학생1의 중간고사 총점이 더 높음");
		} else if(total1 < total2) {
			System.out.println("학생2의 중간고사 총점이 더 높음");
		} else {
			System.out.println("두 학생의 중간고사 총점이 같음");
		}
		
		

	}

}
