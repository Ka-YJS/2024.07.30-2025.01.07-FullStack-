package ex01_inner;

public class Ex02_Transportation {
	public static void main(String[] args) {

		Transportation[]trans = Transportation.values();
		for(Transportation tran : trans) {
			System.out.printf("name : %s, 100km - fare : %d원\n",tran.name(), tran.totalFare(100));
		}

		
	}}
