package ex01_lambda;

@FunctionalInterface
interface IAdd{
	int add(int x, int y);
}

class MathUtils{
	public static int AddElement(int x, int y) {
		return x+y;
	}
}

public class Ex08_lambda {
	public static void main(String[] args) {

		MathUtils mu = new MathUtils();
	//	IAdd addLamda = (x , y) -> MathUtils.AddElement(x, y);는 아래와같이 쓸 수 있음
		IAdd addLamda = MathUtils::AddElement;
		System.out.println(addLamda.add(10, 20));
		
		
	}}
