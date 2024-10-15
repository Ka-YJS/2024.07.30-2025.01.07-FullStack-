package ex02_thread;

class WhiteFlag implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("백기올려");
		}
	}
}

public class RunnableExample {
	public static void main(String[] args) {
	
		WhiteFlag wf = new WhiteFlag();
	//	wf.start(); -> 실행되지않음
		
		Thread t = new Thread(wf);
		t.start();
		
		//Ruannable인터페이스를 익명클래스로 만들어서 람다식으로 표현함 : 
		Runnable blue = () -> {
			while(true) {
				System.out.println("청기올려");
			}
		};
		
		Thread t2 = new Thread(blue);
		t.start();
		
		/*
		순서대로 출력되지않음 
		-> 이유)만약 순서대로 출력된다면 백기올려가 무한루프이므로 청기올려가 나올 수 없음
		하지만 백기올려와 청기올려를 함께 올려놔서 백기와 청기가 같이 나오는 결과를 볼 수 있음*/

	}}
