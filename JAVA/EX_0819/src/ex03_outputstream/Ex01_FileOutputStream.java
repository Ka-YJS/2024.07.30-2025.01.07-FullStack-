package ex03_outputstream;

import java.io.FileOutputStream;

public class Ex01_FileOutputStream {
	public static void main(String[] args) {
		
		try{
			FileOutputStream fos = new FileOutputStream("D:\\web0900_yjs\\1.java/fileout.txt",true);
			//FileOutputStream의 두번째 인자로 true를 주게되면 덮어쓰기가 아닌 이어쓰기가 가능함
			//파일이 없으면 만들어줌, 확장자를 내 마음대로 지정할 수 있음

			//프로그램을 실행하면 아래의 메서드가 실행됨
			fos.write('j');
			fos.write('a');
			fos.write('v');
			fos.write('a');
			fos.write('\n');

			String msg = "fileOutput 예제입니다.\n";
			String msg2 = "여러줄도 가능";

			fos.write(msg.getBytes());//문자열 msg를 byte[]로 변경하는 메서드
			fos.write(msg2.getBytes());

			fos.close();
			} catch( Exception e) {
			
			}
		

	}}
