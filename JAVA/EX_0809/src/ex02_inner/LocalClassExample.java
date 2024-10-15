package ex02_inner;

//LoacalClassExample 처음입력 :

public class LocalClassExample {
	
	private int speed = 10;
	
	public void getUnit(String unitName) {
		
		class Unit{
			public void move() {
				System.out.println(unitName + "이 " + speed + " 속도로 이동합니다.");
			}//moveEnd
		}//UnitEnd
		
		Unit unit = new Unit();
		unit.move();//메서드를 호출함
	}//getUnit( );End
	
	public static void main(String[] args) {
		
		LocalClassExample local = new LocalClassExample();
		local.getUnit("마린");
	}

}



/* 지역 클래스의 접근 제한 : unitName변경해보기
 	->원본을 마음대로 바꿀 수 없게 제한해놓음

public class LocalClassExample {
	private int speed = 10;
	
	public void getUnit(String unitName) {
		unitName = unitName + " 님";
		
		class Unit{
			public void move() {
				//unitName에서 에러 발생
				System.out.println(unitName + "이 " + speed + " 속도로 이동합니다."); 
			}
		}
		
		Unit unit = new Unit();
		unit.move();
	}
	
	public static void main(String[] args) {
		LocalClassExample local = new LocalClassExample();
		local.getUnit("마린");
	}
}
*/