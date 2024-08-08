package ex07_test;

public class GoodCalc extends Calculator {
	
	@Override
	public int add(int x, int y) {
		return x+y;
	}

	@Override
	public int substract(int x, int y) {
		
		return x-y;
	}

	@Override
	public double average(int[] a) { //평균을내야될거고, 평균 = 총합/n 하면되나?
		int sum = 0;
		/*
		for(int i=0;i<arr.length;i++) {
			sum +=i;}
		*/
		for(int i :a) {sum +=i;}
	
		double avg = (double)sum/a.length;
		
		return avg;
	}

}
