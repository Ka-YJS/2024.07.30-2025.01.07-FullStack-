package ex02_inputstream;

import java.io.File;
import java.io.FileInputStream;

public class Ex02_FileInputStream {
	public static void main(String[] args) {
		
		
		String path = "D:\\web0900_yjs\\1.java/test.txt";
		
		File f = new File(path);
		
		byte[]read = new byte[100];
		
		FileInputStream fis = null;
		
		if(f.exists()) {
			try {
				fis = new FileInputStream(f);
				//내용을 읽어와서 바이트배열 read에 저장
				
			/*현재 byte[]배열 read에는 test.txt에서 읽어온 데이터들이 저장됨
				->이를 문자열로 재조립하여 출력할 수  있음*/
			} catch (Exception e) {
			}finally {
			try {//잘 읽어오든, 읽어오지못하든 무조건 닫아야 함
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();}}}

	}}
