package ex04_reader;

import java.io.FileReader;

public class Ex01_FileReader {
	public static void main(String[] args) {

		   //char기반의 스트림은 Reader, Writer의 자식 클래스들을 사용
		   //기본적으로 2byte를 지원하기 때문에 2byte언어로 구성된 파일도 쉽게
		   // 입출력이 가능
		try{
		   FileReader fr = new FileReader("D:\\web0900_yjs\\1.java/test.txt");
		   int code = 0;
		   
		   while((code=fr.read()) != -1) {
			System.out.print((char)code);
		/*
		1byte는 아스키 코드로 읽고 2byte는 유니코드로 알아서 읽어서 문자가 깨지거나 하는일이 없다.
		이게 더 좋은거 같은데 음악 파일같은거 전송할 때는 2바이트씩 전송하는게 좋지 않을 수 있다.
		100피스짜리 퍼즐을 옆으로 똑같이 옮긴다고 생각하면 한주먹씩 주는거보다 하나씩 주는게 상식적으로 훨씬 빠를것이다. 
		*/
		   }
			fr.close();
		} catch(Exception e) {
		
		}

	}}
