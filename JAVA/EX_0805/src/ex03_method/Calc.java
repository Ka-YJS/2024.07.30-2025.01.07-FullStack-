package ex03_method;

public class Calc {
	
	//두 수를 더하는 sum메서드 만들기, "두 수의 합은 ~입니다." 라는 출력문 작성
	//CalcMain만들어서 메서드 호출
	
	void sum(int num1, int num2) {
		System.out.println("두 수의 합은 : " + (num1 + num2) + "입니다.");}
	
	
	//Overloading
	int sum(int[]nums) { //:매개변수로 배열을 전달받음
		int result = 0;
		
		for(int i= 0;i<nums.length;i++) {
			
			result += nums[i];//:넘겨받은 배열에 대한 합
			
		}//System.out.println("숫자들의 합은 "+result+"입니다.");
		return result;
	}	
	
	
	
	

}
