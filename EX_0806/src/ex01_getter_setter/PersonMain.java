package ex01_getter_setter;

public class PersonMain {

	public static void main(String[] args) {
		
		Person hong = new Person();
		
		hong.setAge(-30);
		hong.setAge(30);//:age필드에 30대입
		System.out.println("hong의 나이는 "+hong.getAge()+"세입니다.");
		

	}

}
