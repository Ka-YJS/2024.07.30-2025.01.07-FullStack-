package ex01_buffered;
	/*
	문제)
	-N개의 숫자가 공백없이 쓰여져있음 -> 이 숫자를 모두 합해서 출력하는 프로그램 작성
	-입력 : N개의 숫자를 입력받음, 입력된  N개의 숫자만큼 숫자들이 공백없이 주어짐
	-출력 : 입력으로 주어진 숫자 N개의 합을 출력
	-예시 : 
	1>1 -> 한개의 숫자를 입력하겠다. -> 결과 : 1
	2>5 -> 5개의 숫자를 입력(5 4 3 2 1 ) -> 결과 : 15
	3>25 -> 7000000000000000000000000 -> 결과 : 7
	4>11 -> 10 9 8 7 6 5 4 3 2 1 -> 결과 : 46
	*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Sum {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("정수입력 : ");
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		
		//입력받은 문자열을 미리 배열에 담아놓음
		String[]arr = br.readLine().split("");
		
		//내가 입력받은 숫자만큼만 반복
		for(int i=0;i<n;i++) {
			//입력받은 만큼만 더함
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println("총합 : "+sum);

	}}
