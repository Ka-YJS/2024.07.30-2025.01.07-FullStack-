package ex01_interface;

public class Point {
	//2차원 상의 한 점을 표현하는 Point클래스
	
    private int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getx() {
        return x;
    }
    public int gety() {
        return y;
    }
    protected void move(int x, int y) {
        this.x = x;
        this.y = y;

}
}
