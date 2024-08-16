package ex02_thread;

import java.util.Random;
import java.util.Scanner;

/*문제2)
QuizThread클래스를 만들고 Thread를 상속받는다.
startGame()메서드를 만들고 1 ~ 100 사이의 난수 두개를 더하는 문제를 출제, 키보드에서 답을 입력하여 5문제가 정답처리될 때까지 반복한다.
정답을 맞히고 난 후에 모든 문제를 맞추기까지 몇초가 걸렸는지 화면에 출력하며 프로그램 종료

QuizMain클래스 에서는
QuizThread qt = new QuizThread();
qt.start();
qt.startGame();

위 세 줄 이외의 다른 코드는 추가하지 않는다.
단, 사용자가 문제의 정답으로 정수 이외의 문자를 입력했을 경우에
"정답은 정수로 입력하세요"라는 문장이 출력되도록 한다.


---------실행 결과----------- 

23 + 48 = 71
정답!!
66 + 100 = 166
정답!!
68 + 52 = 1
오답
61 + 51 = 112
정답!!
9 + 48 = 57
정답!!
53 + 28 = 81
정답!!
결과 : 24초...*/

public class QuizThread extends Thread {
	
	int a, b;
	int timer = 0;
	int playCount = 0;
	boolean isCheck = true;
	final int FINISH = 5;//출제 문제 갯수
	
	Scanner sc = new Scanner(System.in);
	
	public void startGame() {
		
		while(isCheck) {
			try {
				a = new Random().nextInt(100)+1;
				b = new Random().nextInt(100)+1;
				System.out.println(a+"+"+b+"=");
				int result = sc.nextInt();
				
				if(result==(a+b)) {
					System.out.println("정답");
				}else {
					System.out.println("오답");
					continue;
				}playCount++;
				
				if(playCount == FINISH) {
					System.out.println("결과(소요시간) : "+timer+"초");
					
					isCheck = false;
				}
				
			} catch (Exception e) {
				System.out.println("정답은 정수로 입력하시오.");
				
			}//try-catch
		}//while
	}

	@Override
	public void run() {
		while(isCheck) {
			try {
				Thread.sleep(1000);
				timer++;
			}catch(Exception e){
				
			}//try-catch
		}//override
	}//startGame

}//class QuizThread