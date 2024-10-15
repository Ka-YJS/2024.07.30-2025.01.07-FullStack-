package ex03_method;

import java.util.Random;

public class Start {
	
	/* !!!숙제!!!
	-Start클래스 생성 -> 1~50까지의 난수 발생
	-StartMain클래스 생성 -> 사용자가 키보드를 통해 정수입력받음
	-Start클래스에서 사용자가 입력한 숫자를 판단 -> 발생한 난수보다 크다면 down, 작다면 up 입력
	-사용자가 입력한 숫자와 발생한 난수가 같을 경우 프로그램 종료 -> 몇회만에 정답인지 count
	*/
	
    Random rnd = new Random(); //:난수를 생성하기 위한 Random클래스의 객체
    int rnum = rnd.nextInt(50)+1;//:1~50사이의 난수 생성
    int count = 1;
    
    public String check(int number) {
    	if(number==rnum) {
    		return "정답!";
    	}else if(number>rnum) {
    		return "Down!";
    	}else {
    		return "Up!";
    	}
    }
	
	
	
	

}
