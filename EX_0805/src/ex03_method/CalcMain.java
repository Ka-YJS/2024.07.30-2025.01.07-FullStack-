package ex03_method;

public class CalcMain {

	public static void main(String[] args) {
		
		
		Calc calc = new Calc();
		
		calc.sum(1, 2);
		calc.sum(100, 200);
		calc.sum(7000, 3000);
		calc.sum(10, 7);
		
		System.out.println("=======================");
		
		int[]nums = {100,200,300};
	//	calc.sum(nums);
		
		//필요에 따라 결과값을 변수에 저장하여 활용할 수 있음
		int n = calc.sum(nums);
				
				System.out.println("총합 : "+n);

	}

}
