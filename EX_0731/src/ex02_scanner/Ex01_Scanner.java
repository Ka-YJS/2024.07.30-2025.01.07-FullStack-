package ex02_scanner;

import java.util.Scanner;

public class Ex01_Scanner {	
	
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		/*
		System.out.print("나이를 입력해주세요 : ");
		int age = scan.nextInt();
		System.out.printf("제 나이는 %d세 입니다.\n", age);
		
		
		System.out.println("------------------------");
		
		System.out.print("이름 입력: ");
		String name = scan.next();
		System.out.println("제 이름은 "+name+"입니다.");
		
		System.out.print("나이 입력: ");
		int age2 = scan.nextInt();
		System.out.println("제 나이는 "+age2+"입니다.");
		
		System.out.print("주소 입력: ");
		String address = scan.nextLine();
		System.out.println("제 주소는 "+address+"입니다.");
		
		System.out.print("키 입력: ");
		double height = scan.nextDouble();
		System.out.println("제 키는 "+height+"입니다.");
		
		*/
		
		System.out.println("------------------------");
		
		System.out.print("이름 입력: ");
		String name = scan.next();
		
		System.out.print("나이 입력: ");
		int age2 = scan.nextInt();
		
		scan.nextLine();
		
		System.out.print("주소 입력: ");
		String address = scan.nextLine();
		
		System.out.print("키 입력: ");
		double height = scan.nextDouble();
		
		System.out.printf("제 이름은 %s입니다.\n",name);
		System.out.printf("제 나이는 %d입니다.\n",age2);
		System.out.printf("제 주소는 %s입니다.\n",address);
		System.out.printf("제 키는 %.1fcm입니다.\n",height);
		
		
		
		

	}

}
