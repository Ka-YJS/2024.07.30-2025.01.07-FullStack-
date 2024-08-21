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

        	public void fToc() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("화씨온도를 입력하세요 : ");
		double faher = sc.nextDouble();
		
		double cel =  (faher-32)/1.8;
		
		System.out.println("섭씨로 변화된 온도는 : " + cel+"입니다.");
	}
	
	public void cTof() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("섭씨온도를 입력하세요 : ");
		
		double cel = sc.nextDouble();
		double faher = 1.8 * cel + 32;
		
		System.out.println("화씨로 변화된 온도는 : " + faher +"입니다.");
	}
        
    }}
