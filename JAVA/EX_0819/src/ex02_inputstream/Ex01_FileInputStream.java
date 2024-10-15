package ex02_inputstream;

import java.io.File;
import java.io.FileInputStream;

public class Ex01_FileInputStream {
	public static void main(String[] args) {
		
		
		String path = "D:\\web0900_yjs\\1.java/test.txt";
		
		File f = new File(path);
		//경로가 이상이 없는지, 존재하는지 검증을 하고 이상이 없으면 읽어오기
		FileInputStream fis = null;//FileInputStream fis 변수는 try안에서만 쓸 수 있었기때문에 밖으로 꺼내줌
		
		if(f.exists()) {
			try {
				fis = new FileInputStream(f);
				
				int code = 0;//한 바이트씩 읽어와서 담아줄 변수
				
				/*
				 read( )메서드가 글자를 읽어오는 작업을 함
				 but. 텍스트를 1byte씩밖에 읽을 수 없기때문에 한글 데이터를 읽는게 불가능함
				 (한글은 2~3byte이기 때문)
				 */
				while((code = fis.read()) !=-1) {
					System.out.println((char)code);
					//더이상 읽어올 단어가 없으면 문장의 끝(End Of File)인 -1를 반환함
					//아스키코드, 유니코드 어느 곳에서도 -1의 의미를 갖고있는 것은 없기때문
				}
				
			  /*스트림은 사용이 완료된 이후 close를 통해 닫아주는 것이 좋음
				그래야 다음 작업시 문제가 생기지 않음. close를 하지않으면 작업이 남았다고 생각할 수 있기때문
				그래서 화면에 띄우거나 파일을 만들면 안된다고 인식할 수 있음*/
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {//잘 읽어오든, 읽어오지못하든 무조건 닫아야 함
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}}
