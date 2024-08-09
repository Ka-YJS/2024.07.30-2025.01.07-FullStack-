package ex03_anonymous_class;

public class PersonMain {
	public static void main(String[] args) {
		
		Student s = new Student();
	  //Person s = new Student();도 가능함
		s.mySelf();
//if. Person을 상속받아 처리해야 하는 클래스가 또 필요하지만 한번만 사용할 거라면 굳이 상속할 필요가 없음		

		//회사원을 만들고싶지만 Person w = new Person()은 그냥 사람일 뿐임
		Person w = new Person() { //Person w = new Person() { };->이렇게 변경한 것이 익명클래스임
		
		//익명클래스 : 
		@Override
		public void mySelf() {
			System.out.println("나는 회사원 입니다.");
		}};
		
		w.mySelf();
		
		Person p = new Person() {/*익명클래스*/};
		
	}
}
