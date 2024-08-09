package ex02_inner;

public class PermitExample {
	
	private class InClass{
		public void print() {
			System.out.println("접근을 private로 제한한다.");
		}
	}
	
	public InClass getInClass() { //반환형의 타입은 InClass임
		InClass in = new InClass();
		return in;
	}
	
	public static void main(String[] args) {
		
		PermitExample permit = new PermitExample();
		permit.getInClass().print();
	}

}
