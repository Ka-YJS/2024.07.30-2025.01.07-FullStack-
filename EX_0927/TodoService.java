package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.presistence.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	
	//TodoRepository 생성자 주입하기
	private final TodoRepository repository;
	
	//메서드형태로 비즈니스로직을 구현함
	public String testService() {
//		return "Test Service";
		
		//TodoEntity생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		
		//TodoEntity를 저장 -> save( ) : insert라고 보면 됨, 저장하면서 자동으로 생성된 key값을 ID에 메핑함
		repository.save(entity);
		
		//TodoEntity를 검색
		//findById(entity.getId()) : 기본키를 이용해 DB에 저장된 TodoEntity찾기
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		
		return savedEntity.getTitle();
		
		
	}}
