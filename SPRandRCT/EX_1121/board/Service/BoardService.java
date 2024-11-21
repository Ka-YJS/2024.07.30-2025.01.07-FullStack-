package com.korea.board.Service;

import org.springframework.stereotype.Service;

import com.korea.board.Entity.BoardEntity;
import com.korea.board.Repository.BoardRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository repository;
	
	public String testService() {
		BoardEntity entity = BoardEntity.builder().title("게시글이 없습니다").build();
		repository.save(entity);
		BoardEntity savedEntity = repository.findById(entity.getId()).get();
		return savedEntity.getTitle();
		
	}
	


}
