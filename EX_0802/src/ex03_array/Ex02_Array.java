package ex03_array;

public class Ex02_Array {

	public static void main(String[] args) {
		
		int [] arr = new int [4];
		
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		arr[3] = 400;
		
		//위에 배열값 4개를 반복문으로 변경하면 아래와 같음 +출력추가
		
		for(int i = 0; i < 4; i++){ //조건식을 i < arr.length로 해도 됨
			arr[i] = (i+1)*100;
			System.out.println(arr[i]);
		}
		
		System.out.println("배열의 길이"+arr.length);
		
		for(int i = 0; i < arr.length ; i++){ 
			System.out.println(arr[i]);
		}
		


	}

}
