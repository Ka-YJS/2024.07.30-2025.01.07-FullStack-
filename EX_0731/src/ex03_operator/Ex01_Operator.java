package ex03_operator;

public class Ex01_Operator {

	public static void main(String[] args) {
		
		/*단항연산자
		 * 피연산자가 한개인 연산자를 말하며, 부호연산자(+,-), 증감연산자(++,--), 논리부정연산자(!)가 있음
		 * */
		
		int x = 100;
		int resultPlus = +x;
		int resultMinus = -x;
		
		System.out.println(resultPlus);
		System.out.println(resultMinus);
		
		double d = 1.11;
		double result = -d;
		System.out.println(result);
		System.out.println(-d);
		System.out.println(d); //위에 result가 -d여도 여기까지 영향을 미치지않음
		

	}

}
