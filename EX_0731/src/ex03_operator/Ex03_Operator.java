package ex03_operator;

public class Ex03_Operator {

	public static void main(String[] args) {
		
		int x = 100;
		int y = 200;
		int result = x + y;
		
		System.out.println(x + y);
		System.out.println(result);//위랑 같은 결과값, 임시로 저장하고싶을 때 이렇게 사용가능
		System.out.println(x - y);
		System.out.println(x * y);
		System.out.println(x / y);
		System.out.println(x % y);
		
		//계산결과가 표현범위를 벗어나면 오버플로우가 발생 혹은 이상한 값이 입력됨
		//참고)result = 100000 * 100000;
 		
		//산술변환
		
		float f1 = 3.14f;
		int i1 = 4;
		
		System.out.println(f1 + i1);
		
		

	}

}
