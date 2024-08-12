package ex03_string;

public class Ex01_String {
	public static void main(String[] args) {

		String str = "Kim Mal Ddong";
		System.out.println("문자열 str의 길이 : " + str.length());
		
		//문자열의 길이(length) :
		int index = str.indexOf('k');
		System.out.println("맨 처음 문자 k의 위치 : " + index);//대소문자 구별 함
		
		//특정문자의 위치_indexOf(char ch)
		System.out.println("문자 a의 위치 : "+ str.indexOf('a'));
		
		//indexOf(String str)
		index = str.indexOf("Mal");
		System.out.println("문자열 Mal의 위치 : " + index);//띄어쓰기 포함
			
		//indexOf(char ch)
		index = str.lastIndexOf('n');
		System.out.println("마지막 문자 n의 위치 : " + index);
		index = str.lastIndexOf('d');
		System.out.println("마지막 문자 d의 위치 : " + index);//글자가 겹치면 뒤에 오는 걸로 취급함
		
		//인덱스를 통해 문자 받아오기_charAt(int index)
		System.out.println("추출한 문자 : "+str.charAt(4));
		char c = str.charAt(4);
		System.out.println("추출한 문자 : " + c);
				
		//특정 문자열만 잘라내기
		String str2 = str.substring(0, str.indexOf('M'));
		System.out.println("0번째부터 M앞자리까지 글자 잘라내기 : " + str2);
		System.out.println("잘라낸 str2의 길이 : " + str2.length());//길이는 띄어쓰기 포함 1부터 증가
		
		System.out.println("0번부터 5번까지 잘라내기 : "+str.substring(0,6));
		
		System.out.println("=====================================");
		
		/*
		스트링은 아니지만 스트링으로 작성된 숫자형태의 문자열을 실제 정수로 바꿔주는 코드
		String number = "1";
		System.out.println(Integer.parseInt(number) + 10); */

		int number = 1;
		String s1 = Integer.toString(number);
		System.out.println(s1);
				
		//split( ) : 문자열을 특정기준으로 잘라서 배열로 저장하기
		String arr[] = str.split(" ");//띄어쓰기를 기준으로 분할

		for(int i = 0; i < arr.length; i++)
			System.out.println("arr[" + i + "] : " + arr[i]);
		
		
		
		
	}
}
