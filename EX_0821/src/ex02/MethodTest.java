package ex02;

/*4. 배열의 최대값을 찾는 maxFinder메서드 작성하기
- 최대값을 찾아야 하는 배열은 매개변수로 전달받는다.
- 배열의 최대값을 찾아서 메서드 안에서 출력하고 종료합니다.
- 메서드는 MethodMain클래스에서 호출합니다.
- 최대값을 찾을 배열은 int[] arr = {4,1,2,10,7,9,5,6,3,8} 입니다.*/

public class MethodTest {
    public static void maxFinder(int[] arr) {
        int max_result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max_result) {
            	max_result = arr[i];
            }
        }
        
        System.out.println("최대값: " + max_result);
        
    }}
