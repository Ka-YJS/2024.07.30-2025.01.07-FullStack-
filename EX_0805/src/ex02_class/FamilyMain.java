package ex02_class;

public class FamilyMain {

	public static void main(String[] args) {
		
		Family father = new Family();
		Family son = new Family();
		
	//	father.address = "인천";
		
		//정적멤버의 호출 -> 클래스명.필드 or 클래스명.메서드명( );
	//	Arrays.sort(); //:클래스명.메서드명(); -> sort();=static 메서드
		
		Family.address = "인천";
		
		System.out.println(son.address);
		System.out.println(father.address);
		
		

	}

}
