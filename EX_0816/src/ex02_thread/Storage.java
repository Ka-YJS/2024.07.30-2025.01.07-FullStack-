package ex02_thread;

public class Storage {
	
	private int stackCount = 10;
	public synchronized void addStack(int stackCount) {
		this.stackCount += stackCount;
		if(this.stackCount >= 10) {//쌓은게 10개보다 많아지면 나르는 애를 다시 깨워서 일시키기
			System.out.println("== 스레드 깨우기 ===");
			notify();
			//wait()을 만나 대기상태에 빠진 스레드는 notify()를 만나 재 구동됨
		}
	}//addStack
	
	//popStack : 물건을 나르는 메서드
	public synchronized void popStack(int leaveCount) {
		try {
			if(leaveCount > this.stackCount) {//leaveCount : 날라야하는 재고, stackCount : 남은재고
				this.stackCount = 0;
			} else {
				this.stackCount -= leaveCount;//:나르는 개수
			}//if-else
			
			if(this.stackCount == 0) {//:재고가 0임 -> 나르는거 멈춤
				System.out.println("== 짐 없음 -> 대기 ===");
				wait();//스레드가 진행중에 wait()을 만나면 일시적으로 정지됨
				//스레드가 구동되고 있을 때 일시적으로 대기상태에 보내고, 다른 스레드에게 제어권을 넘김
				System.out.println("==짐 없음 -> 대기완료===");
			}
		} catch (Exception e) {
			
		}//try-catch
	}//popStack
	
	//getStackCount : 쌓여있는 물건의 개수가 몇개인지 반환하는 메서드
	public int getStackCount() {
		return this.stackCount;
	}

}
