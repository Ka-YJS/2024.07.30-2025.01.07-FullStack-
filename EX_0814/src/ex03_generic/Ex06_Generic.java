package ex03_generic;

class FruitBox3<T>{
	 public T addBox(T x, T y) {
		 
		 /*
		  아래와 같이 제네릭 클래스에서 제네릭 타입 파라미터를 사용하는 메서드를
		제네릭 메서드라고 착각하기 쉬운데, 이것은 그냥 타입 파라미터로 타입을 지정한 메서드일 뿐임
		  */
		 
		 return x;
	    }
	 
	 //static의 이유 : 부모객체를 생성하지않고 addBoxStatic을 호출가능
	 public static <T> T addBoxStatic(T x, T y) {
		 /*
		  제네릭 메서드란, 메서드의 선언부에 <T>가 선언된 메서드를 말함
		직접 메서드에 <T>을 설정함으로서 동적으로 타입을 받아와 사용할 수 있는
		독립적으로 운용 가능한 제네릭 메서드라고 이해하면 됨
		  */
		 return x;
	    }
}

public class Ex06_Generic {
	public static void main(String[] args){
		
		FruitBox3.<Integer>addBoxStatic(1,2);
	}

}
