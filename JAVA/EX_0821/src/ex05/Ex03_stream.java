package ex05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03_stream {
	public static void main(String[] args) {

		//특정 범위의 정수를 요소로 갖는 스트림 생성하기
		IntStream intStream1 = IntStream.range(1, 5); // [1,2,3,4]
		IntStream intStream2 = IntStream.rangeClosed(1, 5); // [1,2,3,4,5]
		
		Stream<Integer>boxedIntStream = IntStream.range(1, 5).boxed();

	}}
