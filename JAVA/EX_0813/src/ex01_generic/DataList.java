package ex01_generic;

public class DataList {
	/*
	private Object[] data;//Object타입의 배열
	private int size;//배열의 크기
	private int defaultSize = 10;//기본배열의 크기
	
	//생성자를 호출하면 기본크기만큼의 배열을 생성
	public DataList() {
		data = new Object[defaultSize];
	}
	
	//생성자 오버로딩을 통해 내가 원하는 크기만큼의 배열을 생성함
	public DataList(int size) {
		//int size는 매개변수(지역변수)이므로 위에서 private int size와는 상관x, public DataList내에서만 사용
		data = new Object[size];
	}
	
	//매개변수에 전달된 값을 배열에 순차적으로 대입하는 add메서드
	public void add(Object value) {
		data[size++] = value;
	}
	
	//인덱스를 전달받아 배열에 들어있는 값을 반환받는 get메서드
	public Object get(int index) {
		return data[index];
	}

	//배열의 크기를 반환하는 size( )메서드
	public int size() {
		return size;
	}
	*/
	 /*
	 -위 클래스는 데이터를 저장할 수 있는 자료구조임
	 -이 클래스 내부의 배열 타입은 Object임
	 -Object는 모든 클래스의 최상위 클래스이므로 어떠한 데이터 형태라도 저장이 가능함
	 -하지만 데이터를 저장한 후 실제 꺼내어 사용하려면 어떤 데이터 타입을 지녔는지 일일히 확인해야 하고, 
	 약속한 데이터가 입력되지 않아 에러가 발생할 수도 있다.
	 */

}
