package ex03_array;

public class Ex05_Arrays {

	public static void main(String[] args) {
		
		int [] arr = {1,6,2,3,10,7,4,8,5,9};
		
		int temp = 0; //:잠깐 담아놓을 변수
		
		for(int i = arr.length - 1; i > 0; i--) {
			
			for(int j = 0; j < i; j++) {//앞의 값이 뒤의 값보다 크다면 정렬
				
				if(arr[j] > arr[j+1]) {//:앞뒤 값을 비교함
					
					//뒤의 값을 임시 변수에 저장
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		//배열의 출력
		System.out.println("정렬 후 출력 : ");
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		
		
		
		
		
		
		
		

	}

}
