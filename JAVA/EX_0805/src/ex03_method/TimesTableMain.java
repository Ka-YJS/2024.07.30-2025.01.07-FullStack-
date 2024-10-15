package ex03_method;

import java.util.Scanner;

public class TimesTableMain {public static void main(String[] args) {
	


    
    TimesTable tt = new TimesTable();//:TimesTable객체 생성
    
    Scanner sc = new Scanner(System.in);
    System.out.print("출력할 단 입력 : ");
    int num = sc.nextInt();

    tt.showTable(num);

	}
}


