package ex04_reader;
	/*
	문제)
	-특정경로에 reader.txt파일을 만들고 아무 내용이나 적는다.
	-reader.txt파일을 읽어서 알파멧 대문자와 소문자의 개수를 출력하세요.
	-출력결과 : 
		대문자 : x개
		소문자 : x개*/

import java.io.File;
import java.io.FileInputStream;

public class Ex02_FileReader {
	public static void main(String[] args) {
		
		String path = "D:\\web0900_yjs\\1.java/red.txt";
		File f = new File(path);
		FileInputStream fis = null;
		
		int count_upper =0;
		int count_lower =0;
		
		
		if(f.exists()) {
			try {
				fis = new FileInputStream(f);
				
				int code = 0;
				
				while((code = fis.read()) !=-1) {
					System.out.print((char)code);
					
						if(code >= 'A' && code <= 'Z') {
							
							count_upper++;
							
						}if(code >= 'a' && code <= 'z'){
							
							count_lower++;
						}

				}//while
				System.out.println();
				System.out.printf("대문자 : %d개",count_upper);
				System.out.println();
				System.out.printf("소문자 : %d개",count_lower);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}//try-catch,finally
		}//if
		


	}}
