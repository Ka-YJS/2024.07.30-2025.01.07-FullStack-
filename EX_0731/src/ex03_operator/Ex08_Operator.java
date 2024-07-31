package ex03_operator;

import java.util.Scanner;

public class Ex08_Operator {

	public static void main(String[] args) {
		
		/*문제1)
		 * 과수원에서 배, 사과, 오렌지를 하루에 각각  5,7,5 생산함
		 * 1. 과수원에서 하루에 생산되는 과일의 총 개수
		 * 2. 시간당 총 생산량 구하기		*/

		int pear = 5;
		int apple = 7;
		int orange = 5;
		
		int total = pear + apple + orange;
		System.out.println("하루 생산되는 과일의 총 개수 : "+total);
		
		double hour_total = (double)total/24;
		System.out.println("시간 당 총 생산량 : "+hour_total);
		
		
		System.out.println("========================");
		
		/*문제2)
		 * 상자 하나에는 농구공이 5개가 들어갈 수 있음
		 * 만약 농구공이 23개라면 몇개의 상자가 필요한가?
		 * ->삼항연산자사용
		 * ->공의 개수가 5로 나누어 떨어지면 몫만큼 필요
		 * ->공의 개수가 5로 나누어 떨어지지않으면 몫+1만큼
		 */
		
		/*
		Scanner sc = new Scanner(System.in);
		
		int inbox = 5;
		System.out.print("농구공의 총 개수 입력 : ");
		int all = sc.nextInt();
		
		int answer = (all%inbox) == 0    ? all/inbox : (all/inbox)+1;
		System.out.println(answer);
		
		*/
		
		
		int ball = 23;
		int n = 5;
		
		int result = ball % n == 0 ? ball/n : (ball/n)+1;
		System.out.println(result);
		
		
		System.out.println("========================");
		
		
		/*문제3)국 영 수에 대한 점수를 정수로 입력받고,
		 * 1. 세 과목에 대한 합계 출력
		 * 2. 평균 출력(합계/3.0)
		 * 	  세 과목의 점수와 평균을 가지고 합격 여부를 처리하는데
		 * 3. 세 과목의 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격 아니면 불합격
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하시오.");
		
		System.out.print("국어점수 : ");
		int language = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int english = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		
		int sum = language + english + math;
		double avg = ((sum)/3.0);		
		System.out.printf("합계 : %d // 평균 : %f\n",sum,avg);
		
		
		String result2 = (language>=40 && english>=40 && math>=40 && avg>=60) ? "합격" : "불합격";
		System.out.println(result2);
		
		

	}

}
