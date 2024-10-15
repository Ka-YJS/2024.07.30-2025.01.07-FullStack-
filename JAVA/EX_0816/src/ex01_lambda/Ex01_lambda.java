package ex01_lambda;

interface Iminus{
	int minus(int x, int y);
}

public class Ex01_lambda {
	
	public static void main(String[] args) {
		
		//람다식을 반환값에 넣음
		Iminus im = makeFunction();//==(x,y) -> x - y;
		int res = im.minus(3, 1);
		System.out.println(res);
	}
	
	//반환형은 반환값의 타입이랑 일치해야함 -> 반환형 : Iminus
	public static Iminus makeFunction() {
		return (x,y) -> x - y;
	}

}
