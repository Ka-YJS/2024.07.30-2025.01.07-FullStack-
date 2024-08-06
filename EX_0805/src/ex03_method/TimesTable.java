package ex03_method;

public class TimesTable {
	
	/*문제1)
	-TimesTable클래스에서 showTable()메서드를 정의
	-showTable()메서드는 구구단을 출력하는 코드를 작성함
	-TimesTableMain클래스에서 키보드에서 정수 하나 입력받아 입력받은 정수의 구구단 출력
	*/
	
	public void showTable(int dan) {//:매개변수로 dan을 전달받음
		System.out.println(dan+"단");
		
		for(int i=1;i<=9;i++) {
			System.out.printf("%d x %d = %d\n",dan,i,(dan*i));//:구구단을 구하는 코드
		}
	}
	
	
	

}
