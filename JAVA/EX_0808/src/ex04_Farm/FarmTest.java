package ex04_Farm;

class Animal{
	public void cry() {};//:오버라이드를 하기위한 메서드
}
class Pig extends Animal{
	@Override
	public void cry() {
		System.out.println("꿀꿀");
	}
}
class Cow extends Animal{
	@Override
	public void cry() {
		System.out.println("음메");
	}
}

class Farm{
	
	/* 1번
	
	public void sound(Pig pig) {
		System.out.println("꿀꿀");
	}
	public void sound(Cow cow) {
		System.out.println("음메");
	}
	->이것도 가능하지만 오버로드해서 아래처럼 표현하는 것이 좋음

	*/
	
	/* 2번 
	 
	 
	public void sound(Animal animal) {
		
		if(animal instanceof Pig) {
			System.out.println("꿀꿀");
		} else {
			System.out.println("음메");
		}
	}
	*/
	
	//3번 클래스에 오버라이딩을 통해서 간략하게 표현
	public void sound(Animal animal) {
		animal.cry();
	}
	
}


public class FarmTest {
	
	public static void main(String[] args) {
		
		Farm f = new Farm();
		Pig p = new Pig();
		Cow c = new Cow();
		
		f.sound(p);
		f.sound(c);
	}

}
