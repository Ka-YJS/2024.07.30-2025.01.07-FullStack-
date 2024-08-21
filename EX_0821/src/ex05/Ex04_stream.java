package ex05;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04_stream {
	public static void main(String[] args) {
		
		Integer[] nums = {1,44,33,21,36,68,88,4,5,6,1,1,1,2,2,2};
		
		//1. 스트림 객체 생성
		Stream<Integer> stream =  Arrays.stream(nums);
		
		//2. 스트림에 중간연산
		stream.distinct().sorted().limit(5).forEach(x -> System.out.print(x+" "));
		System.out.println("===================================");
		
		//rangeClosed() : 정수 범위를 생성
		IntStream intStream = IntStream.rangeClosed(1, 10);//1~10까지의 범위를 가짐
		//skip(n) : 맨 처음 n개를 버리고 시작함
		//limit(n) : n개의 개수를 갖는 스트림을 반환
		intStream.skip(3).limit(5).forEach(x-> System.out.print(x+" "));
		System.out.println();
		System.out.println("===================================");
		System.out.println(Arrays.toString(nums));
		System.out.println("===================================");

		IntStream inStream2 = IntStream.of(1,2,2,3,3,4,5,5,6,7,8,9,10);
		inStream2.distinct().filter(x -> x % 2 == 0).forEach(x -> System.out.print(x+" ")); //2 4 6 8 10
		System.out.println("===================================");
		
		System.out.println();
		//문자열의 길이가 3이상인 문자열만 출력
		Stream.of("ab","a","abc","abcd","abcdef","abcdefg").filter(x -> x.length() > 2).forEach(x-> System.out.print(x+" "));

	}}
