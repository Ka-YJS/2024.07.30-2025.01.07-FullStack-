package ex03;

/*6. 공통부분 추출하기
- 아래 세 개의 클래스로부터 공통부분을 뽑아서 Unit이라는 클래스를 만든다.
- Unit클래스를 상속받도록 코드를 변경하시오.*/

public class Unit {
			private int x, y; //현위치
			void move(int x, int y) {}//지정위치이동
			void stop() {}//현재위치정지
		}
		class Marine extends Unit{
			void stimPack() {}
			
		}
		class Tank extends Unit{
			void changeMode() {}
		}
		class Dropship{
			void load() {}
			void unload() {}
		}

