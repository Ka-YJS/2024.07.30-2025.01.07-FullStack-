package ex01_interface;
	/*
	문제2)
	-Point를 상속받아 색을 가진 점을 나타내는 ColorPoint작성
	-main메서드 실행결과 : Red색의 (10,20)의 점입니다.
	*/
		
public class Main {
	public static void main(String[] args) {
		
        ColorPoint cp = new ColorPoint(5,5,"Yellow");
        cp.setXY(10,20);
        cp.setColor("Red");
        String str = cp.toString();
        System.out.println(str+"입니다.");
		
	
}
	
}
