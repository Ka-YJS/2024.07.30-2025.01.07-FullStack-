package ex01_generic;

public class DataListExample {
	public static void main(String[] args) {
		/*
		//DataList객체 생성하기 - 변수명은 list
		DataList list = new DataList();
		
		//정수입력
		list.add(10);
		
		//문자열저장
		list.add("문자열");
		
		//실수저장
		list.add(13.45);
		
		//문자형 출력
		list.add('B');
		
		//데이터 출력
		for(int i = 0; i < list.size(); i++) {
			
			//데이터 가져오기
			Object data = list.get(i);
			
			//저장된 데이터 타입이 어떤타입인지 검사
			if(data instanceof Integer) {
				System.out.println("정수 : " + (int)data);
			} else if(data instanceof Double) {
				System.out.println("실수 : " + (double)data);
			} else if(data instanceof String) {
				System.out.println("문자열 : " + (String)data);
			}else if(data instanceof Character) {
				System.out.println("문자형 : " + (char)data);
			}
		}
		*/
		/*
		-DataList를 이용해 데이터를 저장하고 출력을 해봄
		-저장 데이터 타입이 Object이므로 어떤 타입의 데이터라도 저장할 수 있지만 
		데이터를 사용할 때는 타입 변환을 위한 검사를 해야 하는 번거로움이 있음
		-이때, 제네릭을 사용하면 원하는 데이터 타입을 자유롭게 저장할 수 있음
		*/

		
	}
}
