package ex05_Iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex02_Iterator {
	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0 ; i <=10; i++) {
			set.add(i);
		}
		
		Iterator<Integer> iter = set.iterator();
		int count = 0;
		
		while(iter.hasNext()) {
			int val = iter.next();
			System.out.printf("set 데이터 [%d] : %d\n",count++,val);
		}

	}
}
