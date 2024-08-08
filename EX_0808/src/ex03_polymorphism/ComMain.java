package ex03_polymorphism;

public class ComMain {
	public static void main(String[ ] args) {
		
		ComputerRoom cr = new ComputerRoom( );
		
		/*
		
		cr.com1 = new Samsung( );
		cr.com2 = new Samsung( ); ->이 두개는 Computer타입
		
		*/
		
		/*
		
		cr.com1 = new LZ();
		cr.com2 = new LZ();
		
		*/
		
	
		cr.com1 = new Mac();
		cr.com2 = new Mac();
		cr.com3 = new Mac();
		
		
		cr.allPowerOn( );
		cr.allPowerOff();
		
		//자식타입으로 바꿔서 변수에 저장하기
		Mac mac = (Mac)cr.com3;
		
		/*
		 -객체를 변경하기 위해 여러 가지 코드를 수정하는 것은 상당히 위험도가 높은 작업임
		 -실무에서의 프로그램은 코드의 양이 많아지고, 수 많은 객체거 서로 얽혀서 복잡한 로직으로 구현되어있음
		 -그렇기 때문에 수정을 최소화 하는것이 좋음
		 */
		
		System.out.println( );

	}

}
