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
	
	int a, b;//난수를 입력받기 위한 변수
	int timer = 0;//시간을 세서 담기위한 변수
	int playCount = 0;//정답을 맞춘 횟수를 저장하기 위한 변수
	boolean isCheck = true;//반복문을 멈추기 위한 변수
	final int FINISH = 5;//맞춰야하는 문제의 갯수
	
	Scanner sc = new Scanner(System.in);
	
	public void startGame() {
		
		while(isCheck) {
			try {
				a = new Random().nextInt(100)+1;
				b = new Random().nextInt(100)+1;
				System.out.println(a+"+"+b+"=");//두개의 난수를 더하는 문제를 콘솔에 출력
				int result = sc.nextInt();//정답입력받기
				//정답을 입력할 때 정수 이외의 것을 입력하면 예외 발생
				
				if(result==(a+b)) {
					System.out.println("정답");
				}else {
					System.out.println("오답");
					continue;//오답일 경우 다시 위로 올라가서 문제맞추기
				}playCount++;//정답을 맞추면 카운트하기
				
				if(playCount == FINISH) {//5개를 맞추면 멈추기
					System.out.println("결과(소요시간) : "+timer+"초");
					isCheck = false;//isCheck를 false로 바꿔 반복문을 빠져나감
				}
				
			} catch (Exception e) {
				System.out.println("정답은 정수로 입력하시오.");
				
			}//try-catch
		}//while
	}//satrtGame

	/*시간초를 세기위한 스레드, startGame( )메서드가 실행되는 동안 별도로 작동하는 스레드*/
	@Override
	public void run() {//isCheck가 false가 되는 순간 반복문이 같이 멈춤
		while(isCheck) {
			try {//sleep을 주기위해 필요함
				Thread.sleep(1000);//1초씩 세야하기때문에 sleep사용
				timer++;
			}catch(Exception e){
				
			}//try-catch
		}//override
	}//startGame

}//class QuizThread
