package ex01_lambda;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex03_lambda {
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList("이름1","이름2","이름3","이름4","이름5"));
		System.out.println(list.toString());
		
		for(String s : list) {
			System.out.println(s+" ");
		}System.out.println();
		
		//https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html 참고
		
		//void accept(T t) -> 람다식으로 t -> System.out.println(t); -> System.out::println
		//마지막결과인 System.out::println를 forEach안으로 넣어줌
		list.forEach(System.out::println);
		//==list.forEach(t -> System.out.println(t+"  "););

	
	
	
	
	
	
	
	}}
