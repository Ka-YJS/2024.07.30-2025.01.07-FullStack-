package ex03_method;

public class Bus {
	
	//메서드를 빠져나가기 위한 return
	
	void take(int m) {
		while(true) {
			if(m<3000) {
				System.out.println("교통카드 충전ㄱ");
				return;
			}System.out.println("버스 탐");
			m -=1400;
		}
	}

}
