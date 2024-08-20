package ex01_inner;

public class Operation_main {
	public static void main(String[] args) {

		double x = 2.5;
		double y = 5.0;
		
		Operation[]oper = Operation.values();
		for(Operation o : oper) {
			System.out.printf("%.1f %s %.1f = %.2f\n",x,o.getOp(),y,o.apply(x, y));
		}

	}}
