package com.example.demo.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop") @Primary
//default값으로 사용 할 클래스에 @Primary어노테이션을 붙이면 이 값으로 고정됨
public class Desktop implements Computer{
	
	@Override
	public int getScreenWidth() {
		
		return 1920;
	}

}
