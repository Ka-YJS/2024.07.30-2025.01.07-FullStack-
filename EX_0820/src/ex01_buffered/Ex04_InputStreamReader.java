package ex01_buffered;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Ex04_InputStreamReader {
	public static void main(String[] args) {
		
		FileInputStream in = null;
		InputStreamReader is = null;
		
		try {
			in = new FileInputStream("test.txt");
			is = new InputStreamReader(in,"UTF-8");
			int read = 0;
			
			while((read = is.read())!= -1) {
				System.out.println((char)read);
			}
		} catch (Exception e) {

		} finally {
			try {
				if(is != null) {
					is.close();//예외가 발생했을때 catch로 가기대문에 close()가 됨
				}
				if(in != null) {
					in.close();
				}
			} catch (Exception e2) {

			}
		}
		
	}}
