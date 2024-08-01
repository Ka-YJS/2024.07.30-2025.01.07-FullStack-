package ex04_if;

import java.util.Scanner;

public class Ex04_if_elseif {

	public static void main(String[] args) {

		
		int favorite = 7;
		
		if(favorite>5) {
			System.out.println("좋아하는 숫자가 5보다 큼");
		}else if(favorite==7) {
			System.out.println("좋아하는 숫자는 7임");
		}
		
		System.out.println("----------------------");
		
		//나이를 키보드에서 입력받음
		//20살 이상이면 성인, 14살이상 청소년, 7살이상 어린이,그 이외 유아
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이 입력 : ");
		
		int age = sc.nextInt();
			//객체명.메서드명(); : 해당 클래스에 있는 메서드의 호출
		
		if(age>=20) {
			System.out.println("성인");
		}else if(14<=age && age<20) {
			System.out.println("청소년");
		}else if(7<=age && age<14){
			System.out.println("어린이");
		}else {
			System.out.println("유아");
		}
		
		
		System.out.println("----------------------");
		
		//키보드에서 성적을 입력받음
		//100~90=a, 89~80=b, 79~70=c, 69~60=d, 59~=f
		//출력: 점수는 ()점이고 성적은 ()입니다
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수 입력 : ");
		
		int score = scan.nextInt();
		char grade;
		
		if(score<=100 && score>=90) {
			grade = 'A';
		}
		else if(score<=89 && score>=80) {
			grade = 'B';
		}
		else if(score<=79 && score>=70) {
			grade = 'C';
		}
		else if(score<=69 && score>=60) {
			grade = 'D';
		}
		else{
			grade = 'F';
		}System.out.printf("제 점수는 %d점이고, %c등급입니다.",score,grade);
		
		
		
		
		
	}

}
