package com.example.demo.di4;

import org.springframework.stereotype.Component;

//코딩을 하기위해서는 컴퓨터가 필요함 -> 컴퓨터에는 ram 이라는 부품을 가지고 있음
@Component
public class Computer {
		
		int ram = 32;
		
		public int getRam() {
			return ram;
		}

	}
