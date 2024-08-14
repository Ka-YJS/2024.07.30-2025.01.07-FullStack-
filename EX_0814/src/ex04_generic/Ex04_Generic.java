package ex04_generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex04_Generic {
	public static void main(String[] args) {
		
		//List<? extends Object> : Object부터 하위클래스가 올 수 있음
		List<? extends Object> list = new ArrayList<String>();//:모든것
		//List<? super String> : String부터 상위클래스가 올 수 있음
		List<? super String> list2 = new ArrayList<Object>();
		
		
	    List<Integer> lists = new ArrayList<>(Arrays.asList(1, 2, 3));
	    print(lists); // OK
	}

	//매개변수로 Number와 그 하위 타입(Integer, Double 등) 만을 받는다
	public static void print(List<? extends Number> list) {
	    for (Object e : list) {
	        System.out.println(e);
	    }
		
	}}
