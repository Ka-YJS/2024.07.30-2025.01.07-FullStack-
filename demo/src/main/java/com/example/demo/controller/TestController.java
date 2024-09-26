package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//:http관련된 코드 및 요청/응답 메핑을 스프링이 알아서 해줌
//@RequestMapping("test")//localhost:9090/test 접속을 시도하면 요청이 이 컨트롤러로 들어와짐
public class TestController {

//	@GetMapping("/testGetMapping")//:get요청으로 들어오면 아래의 메서드를 실행시킴
	@GetMapping("/test/testGetMapping")//이렇게 적어도됨
	//입력해야되는 주소 : localhost:9090/test/testGetMapping
	public String testController() {
		
		return "Hello World";
		
	}
	
	@PostMapping //Post요청이 들어왔을 때
	public String testController2() {
		
		return "Hello World";
		
	}
	
	@PutMapping//Put요청이 들어왔을 때
	public String testController3() {
		
		return "Hello World";
		
	}
	
	@DeleteMapping//Delete요청이 들어왔을 때
	public String testController4() {
		
		return "Hello World";
		
	}
	
	
}
