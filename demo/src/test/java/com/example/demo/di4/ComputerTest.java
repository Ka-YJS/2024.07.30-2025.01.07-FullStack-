package com.example.demo.di4;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComputerTest {
	
	@Autowired
	Coding coding;//스프링이 ComponentScan을 해서 만든 컴퓨터와 코딩에서 만든 객체를 주입해줌
	
	@Test
	public void computerTest() {
//		Coding coding = new Coding(); -> 이렇게 만들 필요가 없음
		System.out.println(coding.getComputer().getRam());
		//맨 처음(@Autowired쓰기 전)에 이론상 출력 값은 null이 나와야 함
	}
}
