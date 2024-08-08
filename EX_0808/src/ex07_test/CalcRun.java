package ex07_test;

public class CalcRun {
	public static void main(String[] args) {
		
		//추상클래스는 직접 객체화할 수 없음
		
        Calculator calc = new GoodCalc();
        int[] a = {1,2,3,4,5};
        System.out.println("합 : "+calc.add(1, 2));
        System.out.println("차 : "+calc.substract(20, 10));
        System.out.printf("평균 : %.2f\n",calc.average(a));

	}

}
