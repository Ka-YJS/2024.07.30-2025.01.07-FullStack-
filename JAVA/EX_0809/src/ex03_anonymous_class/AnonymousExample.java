package ex03_anonymous_class;

interface buttonClickListener{
	//기능은 메서드에 만듦
	public void click();
}

public class AnonymousExample {

	public class Button{
		private buttonClickListener listener;//:필드
		
		public void setButtonListener(buttonClickListener listener) {//: setter를 통해서 필드출력
			this.listener = listener;
		}
		
		//내부메서드
		public void click() {
			if(listener != null) {
				this.listener.click();
			}
		}
		
	}
	
	//버튼객체를 만듦
	public static void main(String[] args) {
		
		AnonymousExample exam = new AnonymousExample();
		AnonymousExample.Button button = exam.new Button();//버튼
		
		button.setButtonListener(new buttonClickListener() {
		//인터페이스 객체는 직접 만들 수가 없음
		//인터페이스를 구현한 클래스를 통해 객체를 만들 수 있음
		
		//(new buttonClickListener~} ); : buttonClickListener인터페이스로부터 만들어진 익명클래스
		//익명으로 인터페이스를 구현한 클래스를 implements한 것과 같음
		//익명클래스 : 상속받는 자식클래스를 따로 만들지 않고, 이름없는 class로 따로 구현한 것으로 같은 역할을 함
			@Override
			public void click() {
				System.out.println("버튼을 눌렀습니다.");
				
			}
		});
		
		button.click();
	}
}