package ex02_constructor;

public class Phone {
	
	String brand;
	int series;
	String color = "검은색";
	
	
	/*처음 입력한 내용 : 
	 * 
		public Phone(String b, int s) {//:p2
		brand = b;
		series = s;
	}
	
	public Phone(String b, int s, String c) {//:p1
		brand = b;
		series = s;
		color = c;
	}
	*/
	
	public Phone(String brand, int series) {//:p2
		this.brand = brand;
		this.series = series;
	}
	
	public Phone(String brand, int series, String color) {//:p1
	//	this.brand = brand;
	//	this.series = series; -> 이 두개가 위에와 겹침
		
		this(brand, series);//:현재 클래스에 선언되어있는 생성자를 가르킬 수 있는 키워드
		this.color = color;
	}
	
	//휴대전화의 정보를 출력하는 phoneInfo()메서드 만들기
	
	public void phoneInfo() {
		System.out.println(color+" "+brand+" "+series+" ");
	}

}
