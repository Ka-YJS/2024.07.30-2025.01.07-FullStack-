package ex01_generic;

//Generic사용해서 코드수정
public class DataList_m<T> {
	
	private Object[] data;
	private int size;
	private int defaultSize = 10;
	
	public DataList_m() {
		data = new Object[defaultSize];
	}
	
	public DataList_m(int size) {
		data = new Object[size];
	}
	
	public void add(T value) {
		data[size++] = value;
	}
	
	public T get(int index) {
		return (T)data[index];
	}

	public int size() {
		return size;
	}
	/*
	-클래스에 제네릭을 부여하게 되면 해당 클래스를 선언할 때 데이터 타입을 부여하게 됨
	-그러면 객체를 생성할 때 타입이 지정된 부분이 대체되어 해당 클래스는 지정된 객체만을 저장할 수 있게 되고, 
	따로 타입을 변환할 필요 없이 데이터를 출력할 수 있음
	-또한, 다른타입의 데이터를 저장하고 싶다면 DataList의 객체를 하나 더 만들고 
	원하는 타입을 부여한 후 사용하면 됨
	 */

}
