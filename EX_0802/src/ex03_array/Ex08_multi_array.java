package ex03_array;

import java.util.Arrays;

public class Ex08_multi_array {

	public static void main(String[] args) {
		
		int [][]arr = new int[3][2];
		
		arr[0][0] =100;
		arr[0][1] =200;
		
		arr[1][0] =300;
		arr[1][1] =400;
		
		arr[2][0] =500;
		arr[2][1] =600;
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println(); //출력값이 따로따로 나옴
		}
		
	//	System.out.println(Arrays.deepToString(arr)); : 다차원배열도 출력가능, 합쳐서 출력됨
		
		int[][]arr2 = {{1,2,3},{4,5,6}};//:2차원배열 초기화
		System.out.println(Arrays.deepToString(arr2));
		
		
		System.out.println("=========================");
		
		//숙제)이차원배열 iArr의 총합구하기
		
		int[][]iArr =  {{1,2,3,4,5},
						{6,7,8,9,10},
						{11,12,13,14,15},
						{16,17,18,19,20}};
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
