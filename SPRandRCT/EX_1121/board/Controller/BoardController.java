package com.korea.board.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.board.DTO.ResponseDTO;
import com.korea.board.Service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	private final BoardService service;
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	//1. 조회 : 임시데이터지우기, DB로부터 조회해서 웹에 출력하기
	//데이터가 없으면 <p>게시글이 없습니다</p> 페이지버튼도 안보이게
	//조회 "/all", 한건조회 "/get/{ id }"
	@GetMapping("/all","/get/{id}" )
	@GetMapping("/get/{id}")
	public ResponseEntity<?>testBoard(){
		String str = service.testService();
		List<String> list = new ArrayList<>();
		list.add(str);
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.ok().body(response);
	}
	
	//2. 추가
	@PutMapping("/write")
	
	//3. 수정
	@PutMapping("/modify/{id}")
	
	//4. 삭제
	@DeleteMapping("/delete/{id}")
	


}
