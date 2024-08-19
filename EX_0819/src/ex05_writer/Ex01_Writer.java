package ex05_writer;

import java.io.FileWriter;

public class Ex01_Writer {
	public static void main(String[] args) {
		
		try{
		FileWriter fw = new FileWriter("D:\\web0900_yjs\\1.java/fileWriter.txt");
		
		fw.write("첫번째 줄 작성합니다.");
		fw.write("\n");
		fw.write("두번째 줄도 문제없음");
		fw.write("\n");
		//이어쓰기가 아닌 덮어쓰기
		System.out.println("작성완료");

		fw.close();

		} catch ( Exception e) {
			e.printStackTrace();
		}
		

	}}
