package ex03_method;

import java.util.Random;

public class Graph {

	public static void main(String[] args) {
		
		/*
		문제2)
		-Graph이라는 이름의 클래스에 main()메서드 만들기
		-난수 0~9를 100개 저장하는 배열만들기 -> 해당 배열이 가지고 있는 각 방(10)의 난수를 판별 -> 그래프화
		-단, 발생한 난수의 그래프화 작업은 PrintGraph클래스가 함
		*/
		
		int[] num = new int[100];//:난수를 담을 배열
		
		int[] count = new int[10];//:발생한 각 난수가 몇개씩 나왔는지 세는 배열
		Random rnd = new Random();//:Random클래스의 객체생성
		
			for(int i = 0; i < num.length; i++){//:난수뽑기
			//0~9사이의 난수 100개를 num 배열에 저장
		System.out.print(num[i] = new Random().nextInt(10));
		}
			System.out.println();
			
			//100개의 난수를 각 숫자별로 몇개씩 나왔는지 count배열에 저장
			for(int i = 0; i < num.length; i++){
			count[num[i]]++;
			PrintGraph pg = new PrintGraph();
				for(int j = 0; j < count.length; j++){
					System.out.println(j + "의 갯수 : " + pg.print('#', count[j]) + " " + count[j]);
		        }//:pg.print -> 그림만 그려주는 그래프
		

		
			}			
	}

	}
