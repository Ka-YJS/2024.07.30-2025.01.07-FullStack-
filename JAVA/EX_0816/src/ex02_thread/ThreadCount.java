package ex02_thread;

public class ThreadCount extends Thread{
	
	private int a;
	
	public ThreadCount(int a) {
		this.a = a;
	}
	
	public void run() {
		for(int i = a ; i>=0 ; i--) {
			try {
				
				System.out.println(i);
				Thread.sleep(1000);
				
			} catch (Exception e) {
			}
			
		}//try-catch
		System.out.println("종료");
	}//run

}
