package ex02_control;

public class Ex01_continue {

	public static void main(String[] args) {

		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("짝수 합 : " + sum);
		
		System.out.println("------------------");
		
		
		int sum2 = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			sum2 += i;
		}
		System.out.println("홀수 합 : " + sum2);
	
	}

}
