package ex01_lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ex07_lambda {
	public static void main(String[] args) {
	
	//	Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);을 아래와같이 나타낼 수 있음
		Function<String, Integer> f1 = Integer::parseInt; 
		System.out.println("정수 100 : "+f1.apply("100"));
		
   //	BiFunction<String, String, Boolean> f2 = (s1, s2) -> s1.equals(s2);을 아래와같이 나타낼 수 있음
		BiFunction<String, String, Boolean> f2 = String::equals;
		
		
		
		
		
		
		
		
		
		
		
		
	}}
