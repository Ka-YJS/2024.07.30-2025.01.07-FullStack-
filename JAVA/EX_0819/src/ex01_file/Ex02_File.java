package ex01_file;

import java.io.File;
import java.util.Arrays;

public class Ex02_File {
	public static void main(String[] args) {
	
		String path = "D:\\web0900_yjs\\1.java/test.txt";
		
		File f = new File(path);
		
		if(! f.isFile()) {//(! f.isFile()==)f.isDirectory : 경로의 최종 목적지가 폴더면 true
			String[] names = f.list();
			System.out.println(Arrays.toString(names));
			
			for(String s : names) {
			    System.out.println(s);	
			    }	
		}//f.list : f경로의 하위 요소들을 문자열 배열로 전환

		
	}}
