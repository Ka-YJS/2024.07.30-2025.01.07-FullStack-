package ex03_method;

import java.util.Scanner;

public class Bread {
	
	String name;
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	
	
	public void makeBread() {
		System.out.println("빵을 만들었습니다.");
	}
	

	public void makeBread(int num) {
		System.out.print("빵 갯수 입력 : "+num);
		this.num = num;
		
		for(int i=0;i<num;i++) {
			System.out.printf("빵을 만들었습니다.");
		}System.out.printf("요청하신 %d개의 빵을 만들었습니다.",num);
	}
	
	public void makeBread(int num, String name) {
		for(int i=0;i<num;i++) {
			System.out.printf("빵을 만들었습니다.");
			
		}System.out.printf("요청하신 %d개의 %s빵을 만들었습니다.",num,name);
		
	}
	

}
