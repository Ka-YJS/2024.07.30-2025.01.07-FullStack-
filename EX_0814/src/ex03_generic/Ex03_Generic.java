package ex03_generic;

	/*멀티타입 파라미터*/

import java.util.ArrayList;
import java.util.List;

class Pear {}
class Peach {}

class FruitBox2<T, U> {
    List<T> pears = new ArrayList<>();
    List<U> peachs = new ArrayList<>();

    public void add(T pear, U peach) {
    	pears.add(pear);
    	peachs.add(peach);
    }
}

public class Ex03_Generic {
	public static void main(String[] args) {
	
    	// 복수 제네릭 타입, 멀티타입 파라미터
        FruitBox2<Pear, Peach> box = new FruitBox2<>();
        box.add(new Pear(), new Peach());
        box.add(new Pear(), new Peach());
	
	
	}}
