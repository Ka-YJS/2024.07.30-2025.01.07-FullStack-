package ex03_generic;

interface ISample<T> {
	//자료구조에 데이터를 추가하는 메서드
    public void addElement(T t, int index);
    //index에 따라 Value를 반환하는 메서드
    public T getElement(int index);
}

//인터에피이스를 구현한 클래스에도 타입 파라미터를 추가해야 함
class Sample<T> implements ISample<T> {
    private T[ ] array;

    public Sample() {
        array = (T[ ]) new Object[10];//타입이 아직 결정 안된상태
    }

    @Override
    public void addElement(T element, int index) {
        array[index] = element;
    }

    @Override
  //index를 매개변수로 받아 array에 들어있는 value를 반환하는 getElement메서드
    public T getElement(int index) {
        return array[index];
    }
}

public class Ex05_Generic {
	public static void main(String[] args) {
		
    	Sample<String> sample = new Sample<>();
    	sample.addElement("This is string", 5);
    	sample.getElement(5);
    	System.out.println(sample.getElement(5));//==array[5]
		
		
	}}
