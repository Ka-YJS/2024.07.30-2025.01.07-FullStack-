package ex01_lambda;

import java.util.function.Function;

public class Ex05_lambda {
	public static void main(String[] args) {
		
		//R apply(T t)
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);//16진수 -> 10진수로 변환
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);//10진수 -> 2진수로 값 바꿔줌
		
		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);
		
		System.out.println(h.apply("FF")); // "FF" -> 255 -> "11111111"
		/*16진수로는 0~9, A~F를 표현할 수 있는데 FF는 16진수가 표현할 수 있는 수중에
		 가장 큰 수라고 할 수 있음*/
		
		Function<Integer, String> x = i -> Integer.toBinaryString(i);
		Function<String, Integer> y = s -> Integer.parseInt(s,16);
		Function<Integer, Integer> z = f.compose(x);
		System.out.println(z.apply(2));// 2 -> "10" -> 16

	
	}}
