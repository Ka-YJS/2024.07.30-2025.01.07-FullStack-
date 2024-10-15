package ex02;

import java.util.Scanner;

/*5. 온도구하기
- 화씨를 섭씨로 바꾸는 fToc메서드
- 메서드 내부에서 온도를 입력받아 화씨를 섭씨로 바꾼 결과를 출력합니다.
- 섭씨를 화씨로 바꾸는 cTof메서드
- 메서드 내부에서 온도를 입력받아 섭씨를 화씨로 바꾼 결과를 출력합니다.
- 섭씨를 화씨로 바꾸는법 : 1.8 * 섭씨 + 32
- 화씨를 섭씨로 바꾸는법 : (화씨-32)/1.8
- MethodMain에서 숫자를 입력받는다.
- 입력받은 숫자가 1이면 fToc메서드 호출하고 2면 cTof를 호출하시오
-섭씨 : C, 화씨 : F*/ 

public class MethodMain {
	public static void main(String[] args) {
		
		int[] arr = {4,1,2,10,7,9,5,6,3,8};
		MethodTest.maxFinder(arr);
		
		System.out.println("===========================");
		
		System.out.print("화씨->섭씨는 1, 섭씨->화씨는 2 || 입력 : ");
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		if(n == 1) {
			mt.fToc();
		} else {
			mt.cTof();
		}
	


}//MethodMain
