package ex02_thread;

class AddThread implements Runnable{// : 하나의 스레드
	
		private Bank b;
		private String name;
		
		public AddThread(String name, Bank b) {
			this.name = name;
			this.b = b;
		}

		@Override
		public void run() {
			synchronized(b) {
			try {
				for(int i =0;i<10;i++) {
					Thread.sleep(1000);//1초동안 멈춤
					b.addMoney(1000);
					System.out.println(this.name+"현재잔고 : "+b.getMoney());
				}//for
			}catch(Exception e) {
				
			}//catch
		}//override
		}//b;
	
}//class

public class BankThreadExample {
	public static void main(String[] args) {
	
		Bank b = new Bank();
		Thread t1 = new Thread(new AddThread("1번",b));
		Thread t2 = new Thread(new AddThread("2번",b));
		//2개의 스레드가 같은 클래스를 참조하고있음, 같은 행동을 하려고 함
		
		t1.start();
		t2.start();
	/*	이대로 실행하면 2000원씩 계좌에 추가되다가 어느순간부터 1000원씩만 추가됨
	 	->최종적으로 계좌 두개의 금액이 16000, 17000이 나옴
		2000씩 10번을 반복하므로 원래는 최종적으로 계좌 두개 다 20000원이 나와야 함
		실행결과에 따라 2만원이 아닌 더 적은 금액이 나올 수 있음
		그 이유는 두 스레드가 서로의 작업에 간섭하여 정상적으로 입금되지 않았기 때문임*/
		
		
		
		
		
		
		
		
		
		
		
		
		
	}}
