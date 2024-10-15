package com.example.demo.qualifier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //테스트에 필요한 의존성을 대신 제공함
public class ComputerTest2 {
	
//	@Autowired @Qualifier("laptop")
//	@Autowired @Qualifier("desktop")
	@Autowired
	Computer computer;//이자리에 주입을 해주려고 할텐데 이자리에 Desttop과 Laptop 모두 올 수 있음 -> 그래서 아래와같은 오류뜸
	
	@Test
	public void widthTest() {
		
		System.out.println(computer.getScreenWidth());
		/*이대로 입력하고 실행하면 expected single matching bean but found 2: desktop,laptop 라는 오류가 나옴
		 -> 하나만 매칭하고싶은데 Desktop과 Laptop의 값 두개가 매칭되어 오류남*/
		
	}

}
