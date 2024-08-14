package ex03_generic;

public class GenEx<T> { //:클래스에 제네릭타입을 선택

	//필드의 타입을 미리 결정하지않음
	T value;
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	//<T>부분에서 실행부에서 타입을 받아와 내부에서 T타입으로 지정한 멤버들에게 전파하여
	//타입이 구체적으로 설정되는 것이다. 이를 구체화(Specialization)라고 한다.

	
	
}
