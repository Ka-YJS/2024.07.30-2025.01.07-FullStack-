package ex01_interface;

import java.util.Scanner;

public abstract class Converter {
	
	abstract protected double converter(double src);//:추상메서드
	abstract protected String getSrcString();//:추상메서드 -> 원화
	abstract protected String getDestString();//:추상메서드 ->달러
	protected double ratio;
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
		System.out.println(getSrcString()+"을 입력하세요. : ");
		double val = sc.nextDouble();
		double res = converter(val);
		System.out.println("반환결과 : "+res +getDestString()+ "입니다");
	}

}
