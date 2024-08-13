package ex05_Iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Ex01_Iterator {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		//asList의 반환형은 List<T>
		
		Iterator<Integer> iter = list.iterator();
		int count = 0;
		
		//향상된 for문을 기반으로 함 -> 처음부터 끝날때까지 작동함
		while(iter.hasNext()) {
			int val = iter.next();
			System.out.printf("list 데이터 [%d] : %d\n",count++,val);
		}

	}
}
