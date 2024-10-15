package com.example.demo.di4;

import lombok.RequiredArgsConstructor;

//코딩을 하려면 컴퓨터가 필요함

//@Component
@RequiredArgsConstructor
public class Coding {
	
	//1. @Autowired
//	@Autowired
//	private Computer computer;
	
//	private Computer computer;
	//@RequiredArgsConstructor추가 -> import -> final이나 @Nonnull붙이면 생성자가 생성됨
	private final Computer computer;
	 
	//2. 생성자 주입  --> 주로 사용되며, 권장됨
	//생성자가 정의됨 -> 생성자가 호출되는 시점은 객체가 만들어질 때
//	public Coding(Computer computer) {//Component로 만들어둔 객체가 매개변수에 주입됨 -> 이게 생성자주입임
//		this.computer = computer;
//}
	
	//3. setter주입
//	@Autowired
//	public void setComputer(Computer computer) {
//		this.computer = computer;
//	}
	
	public Computer getComputer() {
		return computer;
	}

}
