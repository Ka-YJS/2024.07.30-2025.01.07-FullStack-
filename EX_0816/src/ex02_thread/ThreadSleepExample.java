package ex02_thread;

class TimeThread extends Thread{

	@Override
	public void run() {
		for(int i =0;i<1000;i++) {
			System.out.println("스레드 출력 : "+(i+1));
			try {//1초간 일시정지
				Thread.sleep(1000);
				
			}catch(Exception e) {
		//e.printStackTrce(); -> 어떤 오류가 발생하는지 보여주는 코드		
			}
		}//for
	}//override
	
}//class TimeThread

public class ThreadSleepExample {
	public static void main(String[] args) {
	
		TimeThread tt = new TimeThread();
		tt.start();//실행하면 1초에 하나씩 실행됨
		
		
	}}
