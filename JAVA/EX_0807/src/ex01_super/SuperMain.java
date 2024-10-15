package ex01_super;

public class SuperMain {

	public static void main(String[] args) {

			Child c = new Child(1);
			//자식객체를 생성하고 실행 -> 부모생성자 안에 있는 명령이 실행됨
			
			System.out.println("money : "+c.money);
			//:부모객체가 만들어지면서 자식객체가 부모의 필드를 사용할 수 있음
		
		}

	

}
