package ex03_array;

import java.util.Scanner;

public class Ex10_multi_array {

	public static void main(String[] args) {
		
		//문제1)1~25까지 2차원배열 arr에 순차적으로 넣고, 한줄에 다섯개씩 출력 
		
        int[][] arr = new int[5][5];
        
        int count = 1;
        
        for (int i = 0; i <arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                System.out.printf("%02d ",arr[i][j] = count++);
            }System.out.println( );
        }
		
		System.out.println("========================================");
		
		//문제2)로또번호 맞추기
		int[][]lotto = {{2,6,11,33,42,44},
						{1,6,17,22,24,33},
						{7,16,24,33,45,9},
						{27,42,35,21,43},
						{6,17,22,24,33,41}};
        
		//키보드에서 당첨숫자 6개 입력받아서 myNum에 넣기
		String myNum = "";
		
		boolean isWin = false;

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 6개 연속 입력(띄어쓰기미포함) : ");
		myNum =sc.next();
		
		//2차원배열에 들어있는 1차원배열 5개 중 하나라도 완전이 일치하는 곳이 있으면 당첨 아니면 당첨x 출력
		
		for(int i = 0 ; i< lotto.length; i++) {
			String lottoNum = "";//변수를 만들어줌 -> 하나의 일차원배열에 있는 숫자들을 문자열로 붙임
			
			for(int j = 0 ; j < lotto[i].length; j++) {
				lottoNum += lotto[i][j];
			}
			if(myNum.equals(lottoNum)) {
				isWin = true;
				break;//정답맞추면 그 이후로 비교할 필요x -> break
			}
		}
		//isWin -> true면 당첨, false면 당첨아님
		if(isWin) {
			System.out.println(myNum+"번호 당첨");
		} else {
			System.out.println(myNum + "당첨되지 못했습니다.");
		}
		
		
		
		
		
	}

}
