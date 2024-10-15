package ex01_file;

import java.io.File;

public class Ex03_File {
	public static void main(String[] args) {

		//aaa/bbb는 실제 없는 경로
		String path = "D:\\web0900_yjs\\1.java/aaa/bbb";
		
		File f = new File(path);
		//최종목적지가 파일이든 폴더든간에 아예 존재하지가 않음
		
		if(f.exists()==false){ //f.exists() : 최종 목적지까지 가는 길에 없으면 false
			System.out.println("폴더생성");
			f.mkdirs();}//복수의 폴더를 생성, mkdir은 한개의 폴더를 생성

	}}
