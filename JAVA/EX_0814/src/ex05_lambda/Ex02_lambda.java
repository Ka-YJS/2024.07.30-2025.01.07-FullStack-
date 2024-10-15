package ex05_lambda;

@FunctionalInterface
interface Iadd{
	int add(int x, int y);
}

public class Ex02_lambda {
	public static void main(String[] args) {
		
		//람다식을 메서드의 매개변수로 활용할 수 있다.
		Iadd add = (x,y) -> x+y;
		int res = result(add);
		System.out.println("람다식 매개변수로 활용 : " + res);
	}
	
	public static int result(Iadd lamda) {// : Iadd lamda안에 (x,y) -> x+y;가 들어감
		return lamda.add(1, 2);

	}
}
