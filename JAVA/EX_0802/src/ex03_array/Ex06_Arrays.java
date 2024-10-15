package ex03_array;

import java.util.Arrays;
import java.util.Comparator;

public class Ex06_Arrays {

	public static void main(String[] args) {
		
		//배열출력
		
		int[] arr1 = {1,6,2,3,10,7,4,5,8,9};
		
		System.out.println(Arrays.toString(arr1));
		
		System.out.println("==========================");
		
		
		//배열정렬(오름차순)
		
		int[] arr2 = {1,6,2,3,10,7,4,5,8,9};
		
		System.out.println("정렬 전 :" + Arrays.toString(arr2));
		
		Arrays.sort(arr2);
		System.out.println("정렬 후 :" + Arrays.toString(arr2));
		
		
		System.out.println("==========================");
		
		
		//배열정렬(내림차순)
		
		Integer[] arr3 = {1,6,2,3,10,7,4,5,8,9};
		
		
		Arrays.sort(arr3, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr3));
		

	}

}
