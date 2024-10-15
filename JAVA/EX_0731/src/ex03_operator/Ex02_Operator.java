package ex03_operator;

public class Ex02_Operator {

	public static void main(String[] args) {
		
		/*증감연산자
		 * 1씩 증가시키거나 1씩 감소시키는 연산자
		 **/
		
		//선행증감

		int a = 10;
		System.out.println("a : "+ ++a);
		
		
		//후행증감
		int b = 10;
		System.out.println("b : " + b++);
		System.out.println(b);
		
		char alphabetA = 'A';
		System.out.println(alphabetA++);
		System.out.println(alphabetA);
		
		
		//정수타입 연산에서 오버플로우가 발생하면 최소값으로 돌아감
		byte value = 127;
		value++;
		System.out.println(value);//결과값 : -128
		
		//정수타입 연산에서 언더플로우가 발생하면 최대값으로 돌아감
		byte value2 = -128;
		value2--;
		System.out.println(value2);
		
		System.out.println("==================");
		
		int x = 5;
		int y = x++;
		
		System.out.println("x의 값 : "+x);
		System.out.println("y의 값 : "+y);
		
		
		System.out.println("==================");
		
		int x2 = 10;
		int y2 = 20;
		
		int z = (++x2) + (y2--); //z의 값 : 
		
		System.out.println(z);
		
		System.out.println("==================");
		
		boolean isHuman = false;
		System.out.println(isHuman);
		System.out.println(!isHuman);
		
		
		
		
		

	}

}
