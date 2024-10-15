package ex02_inputstream;

import java.io.File;
import java.io.FileInputStream;

/*문제)
	 -특정경로에 file.txt문서를 만들고 아무 문장이나 입력해둔다.
	 -file.txt의 내용을 읽어온 뒤, 회문인지 아닌지 판별해서 출력하시오.
	 */

public class Ex04_FileInputStream {
	public static void main(String[] args) {
		
		String path = "D:\\\\web0900_yjs\\\\1.java/test1.txt";
		
		File f = new File(path);
		byte[] read = new byte[(int)f.length()]; //txt파일의 크기만큼의 배열 생성
		FileInputStream fis = null;

		try{
		   if(f.exists()) {
		   	fis = new FileInputStream(f);
			fis.read(read);//fis가 읽어온 내용을 byte배열에 저장

			//read배열을 String타입으로 변경
			String ori = new String(read);
			String rev = "";

			for(int i = ori.length()-1; i>=0; i--) {
				rev+=ori.charAt(i);
			}//for
			if(ori.equals(rev)) {
				System.out.println(ori + "는 회문입니다");
			} else {
				System.out.println(ori + "는 회문이 아닙니다");
			}
		  }//if
		} catch( Exception e) {

		}finally{
			try {
				   fis.close();
			} catch (Exception e2) {
			}
		}

	}}
