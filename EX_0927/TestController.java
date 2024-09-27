package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;

@RestController//:http관련된 코드 및 요청/응답 메핑을 스프링이 알아서 해줌
@RequestMapping("test")//localhost:9090/test 접속을 시도하면 요청이 이 컨트롤러로 들어와짐
public class TestController {

	/*HTTP메서드마다 요청을 받아오는 어노테이션*/
	
//	@GetMapping("/testGetMapping")//:get요청으로 들어오면 아래의 메서드를 실행시킴
	@GetMapping("/test/testGetMapping")//이렇게 적어도됨
	//입력해야되는 주소 : localhost:9090/test/testGetMapping
	public String testController() {
		
		return "Hello World";
		
	}
	
	@GetMapping("/{id}")
	public String testControllerWidthPathVariables(@PathVariable(required=false)int id) {
		return "Hello world! ID"+id;
	}//입력주소 : localhost:9090/test/123
	
	@GetMapping("/testRequestParam")
	public String testControllerRequestParam(@RequestParam(required=false)int id) {
		return "Hello World! ID" +id;
	}//입력주소 : localhost:9090/test/testRequestParam?id=123
	
	//요청바디에 데이터가 넘어왔을 때 자바객체로 변환하여 사용함
	@GetMapping("/testRequestBody")
    /*@RequestBody TestRequestBodyDTO testRequestBodyDTO
    -RequestBody로 날아오는 JSON을 TestRequestBody객체로 변환해서 가져오라고 요청
    -날아오는 JSON의 형식은 TestRequestBody의 형태와 같아야 할 것임*/
	public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello World! ID"+testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
	
	}
	
	//응답바디에 데이터를 넘기는 것
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody(){
		List<String> list = new ArrayList<>();
		list.add("Hellow World! I'm ResponseDTO");
		ResponseDTO<String>response = ResponseDTO.<String>builder().data(list).build();
		return response;
	}
	
	//HTTP응답을 보다 세밀하게 제어할 수 있음, HTTP상태코드/헤더/바디를 구성할 수 있음
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity(){//<?> : Object의 느낌으로 어떤 자료형이 들어와도 상관없다고 봐도 됨
		List<String> list = new ArrayList<>();
		list.add("Hellow World! I'm ResponseEntity. And you got 400");
		ResponseDTO<String>response = ResponseDTO.<String>builder().data(list).build();
		//http status를 400으로 설정
		return ResponseEntity.badRequest().body(response);
	}
	
}
