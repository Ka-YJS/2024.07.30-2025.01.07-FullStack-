package ex03_operator;

public class Ex05_Operator {

	public static void main(String[] args) {
		
		//논리연산자
		
		
		int myAge = 30;
		int limit = 35;
		
		boolean result = (limit-myAge) < 5 && (myAge+=1) > 30;
		//myAge+=1=31
		System.out.println(result);
		System.out.println(myAge);
		
		System.out.println("----------------");
		
		
		int n1 = 10;
		int n2 = 20;
		
		boolean result2 = (n1+=10) >= 20 || (n2+=1) -10 == 11;
		System.out.println(result2);
		System.out.println(n2);

		
		
		
		
		
		
		
		
		

	}

}
