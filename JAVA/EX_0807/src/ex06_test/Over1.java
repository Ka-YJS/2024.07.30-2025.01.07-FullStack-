package ex06_test;

public class Over1 {

	public static void main(String[] args) {
		
		Over1 a1 = new Over1();
		Over2 a2 = new Over2();
		
		System.out.println(a1.sum(3,2) +a2.sum(3, 2));//5+6=11
		
		//생각)출력결과 : 11
		// 답)출력결과 : 11
		

	}
	
	int sum(int x, int y) {
		return x + y;//2+3=5
	}

}


class Over2 extends Over1{
	
	@Override
	int sum(int x, int y) {
		return x-y + super.sum(x,y);//(3-2)+5=6
	
	
}}