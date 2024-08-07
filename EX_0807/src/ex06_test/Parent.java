package ex06_test;

public class Parent {
	
	int x = 100;
	
	Parent(){
		this(500);
	}
	
	Parent(int x){
		this.x = x;
	}
	
	int getX() {
		return x;
	}

}

class Child extends Parent{
	int x = 4000;
	
	Child(){
		this(5000);
	}
	Child(int x){
		this.x = x;
	}
}

/*
public class Main{
	public static void main(String[] args) {
		
		Child obj = new Child();
		System.out.println(obj.getX());//500->getX는 부모클래스에서 가져옴
		System.out.println(obj.x);//:5000->x는 자식클래스에서 가져옴
		
	}	
}			//생각)출력결과 : ?
			// 답)출력결과 : 500
*/