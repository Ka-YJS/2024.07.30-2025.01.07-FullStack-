package ex03_generic;

import java.util.ArrayList;
import java.util.List;

class Fruit { }
class Apple extends Fruit { }
class Banana extends Fruit { }

class FruitBox<T> {
    List<T> fruits;
    //여기에 new ArrayList<>();를 하면 새로운 ArrayList를 계속 생성
    //사용이 끝나면 소멸됨

    public void add(T fruit) {
        fruits.add(fruit);
    }
}

public class Ex02_Generic {
    public static void main(String[] args) {
    	
        FruitBox<Fruit> box = new FruitBox<>();
        box.fruits = new ArrayList<>();
        //데이터를 계속 저장하면서 사용하고 싶을 때는 객체가 아닌 바깥에서 한번만 생성하면 됨
        
        // 제네릭 타입은 다형성 원리가 그대로 적용된다.
        box.add(new Fruit());
        box.add(new Apple());
        box.add(new Banana());
    
    }
}
