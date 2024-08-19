package ex03_outputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex02_CopyTest {
	public static void main(String[] args) {
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("D:\\web0900_yjs\\1.java/image.jpg");
			out = new FileOutputStream("D:\\web0900_yjs\\1.java/image_copy.jpg");
			
			//현재 시간을 m/s단위로 나타냄
			long start = System.currentTimeMillis();
			System.out.println("이미지 읽기 시작");
			int read = 0;
			while((read = in.read()) != -1) {//쓴다
				out.write(read);
			}//while
			System.out.println("이미지 읽기 종료");
			long end = System.currentTimeMillis();
			long time = (end - start)/1000;
			System.out.println(time+"초");
		} catch (Exception e) {

		} finally {
			try {
				if(out != null) {
					out.close();
				}
				if(in != null) {
					in.close();
				}//in으로 먼저 닫으면 문제가 생길 수 있으므로 close는 역순으로 진행해야 함
			}catch (Exception e) {
			}//try-catch_in
		}//try-catch_out, finally
		
	}}
