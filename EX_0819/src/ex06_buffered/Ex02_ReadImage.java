package ex06_buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ex02_ReadImage {
	public static void main(String[] args) {

		FileInputStream readFile = null;//기반스트림만 사용해서 이미지 읽어보기
		FileInputStream bisReadFile = null;//기반+보조스트림 사용해서 이미지 읽어보기
		BufferedInputStream bis = null;

		try {
			System.out.println("기본 스트림으로 읽기 시작");
			readFile = new FileInputStream("D:\\web0900_yjs\\1.java/image.jpg");
			// 현재 시간을 m/s 단위로 나타냄
			long start = System.currentTimeMillis();
			System.out.println("이미지 읽기 시작1");
			while (readFile.read() != -1) {
					// 이미지 읽기
			}
			System.out.println("이미지 읽기 종료1");
			long end = System.currentTimeMillis();
			long time = (end - start) / 1000;

			System.out.println("소요 시간 : " + time + "초");
			System.out.println("기본 스트림으로 읽기 종료");
			
			System.out.println("-------------------------------------");
			/*보조스트림으로 읽기*/

			System.out.println("보조 스트림으로 읽기 시작");
			bisReadFile = new FileInputStream("D:\\web0900_yjs\\1.java/image.jpg");
			bis = new BufferedInputStream(bisReadFile);

			// 현재 시간을 m/s 단위로 나타냄
			start = System.currentTimeMillis();
			System.out.println("이미지 읽기 시작2");
			while (bis.read() != -1) {
					// 이미지 읽기
			}
			System.out.println("이미지 읽기 종료2");
			end = System.currentTimeMillis();
			double result = (double)(end - start) / 1000;

			System.out.println("소요 시간 : " + result + "초");
			System.out.println("보조 스트림으로 읽기 종료");

		} catch (Exception e) {//try-catch
			
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (bisReadFile != null) {
					bisReadFile.close();
				}
				if(readFile != null) {
					readFile.close();
				}
			} catch (Exception e2) {
				
			}
		}//finally
		
		
	}}
