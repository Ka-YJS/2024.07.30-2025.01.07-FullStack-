package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//Todo테이블에 있는 내용을 담기위한 클래스
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoEntity {
	
	private String id; //이 객체의 id
	private String userId;//이 객체를 생성한 유저의 아이디
	private String title;//Todo 타이틀 예)운동 하기
	private boolean done;//true - todo를 완료한 경우(checked)
	//boolean으로 만든 값은 isDone으로 저장됨
	

}
