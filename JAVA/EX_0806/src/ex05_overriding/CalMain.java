package ex05_overriding;

public class CalMain {

	public static void main(String[] args) {
		
		
		CalPlus cp = new CalPlus();
		System.out.println("CalPlus : "+cp.getResult(15, 15));
		
		CalMinus mn = new CalMinus();
		System.out.println("CalMinus : "+mn.getResult(45, 30));
		
		
		
		

	}

}
