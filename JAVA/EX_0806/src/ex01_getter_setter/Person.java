package ex01_getter_setter;

public class Person {
	
	private int age;//:필드에 직접 접근하지 못하도록 private으로 범위를 제한
	
	public void setAge(int num) {
		if(num <= 0) {// 만약, age에 넣으려는 값이 0보다 작거나 같다면
			System.out.println("잘못된 수를 입력하셨습니다. 1 이상의 값으로 설정하세요");
			return; //메서드 종료
		} else {
			age = num; //age필드에 num값을 대입
		}
	}public int getAge() {//:메서드가 public이면 외부에서 사용 가능
		return age;
	}

	
	
	
	
	
	
	
	
	
	
}
