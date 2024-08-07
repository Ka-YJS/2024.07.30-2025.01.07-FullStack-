package ex01_super;

	/*
	문제1)
	-상속을 이용해서 다음 클래스들을 간결한 구조로 만드세요
	-부모->넓은 범위의 개념, 자식->좁은 범위의 개념
	*/

class Pen{
	
	private int amount;
	public int getAmount(){return amount;}
	public void setAmount(int amount){this.amount = amount;}

}


class SharpPencil extends Pen {//샤프
    private int width; //펜의 굵기
	
}

class Ballpen extends Pen { //볼펜
    private String color; //볼펜의 색
    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}
}

class FountainPen extends Pen {//만년필
	
	public void refill(int n) {setAmount(n);};

}


public class PenMain {
	public static void main(String[] args) {

	
}
	
}




//생각)class A + class B 의 출력물 : B: 11 -> A는 어디감...?안나오나..?A: 100..?
// 답)A B: 11 -> class B에 super()인 기본생성자가 생략되어있으므로 A도 출력해줘야함






