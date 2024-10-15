package ex06_buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ex01_BufferedInput {
	public static void main(String[] args) {

	FileInputStream in = null;//보조스트림을 사용하기위한 기반스트림
	BufferedInputStream bis = null;
	
	try {
		in = new FileInputStream("D:\\web0900_yjs\\1.java/red.txt");
		//경로를 안정해주면 이 파일이 있는 곳(java_work)을 디폴트로 잡음
		bis = new BufferedInputStream(in);
		
		int read = 0;
		
		//보조 스트림을 사용하면 라인 단위로 읽어올 수 있다.
		while((read  = bis.read()) != -1) {
			System.out.print((char)read);
		}
	} catch (Exception e) {
		
	} finally {
		try {
			if(bis != null) {
				bis.close();
			}
			if(in != null) {
				in.close();
			}
		} catch (Exception e2) {
			
		}
	}
	
	}}
