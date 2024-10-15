package ex05;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex01_stream {
	public static void main(String[] args) {
		
		String[]strArray = {"홍길동","김자바","박디비"};//원본배열
		Stream<String>strStream = Arrays.stream(strArray);//배열이 복사되어서 들어감
		strStream.forEach(System.out::println);
		
		int[]intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.print(item+","));
		System.out.println();

	}}
