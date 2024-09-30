package com.example.demo.dto;

import com.example.demo.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
	
	/*DTO에는 userId가 없음
	-> 이부분은 security 처리예정이며, 애플리케이션과 DB에서 사용자를 구별하기위한 
	고유식별자로 사용하기 때문에 숨길 수 있으면 숨기는 것이 좋음*/
	private String id;
	private String title;
	private boolean done;
	
	//DTO -> Entity
	public TodoDTO(final TodoEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.done = entity.isDone();
	}
	
	public static TodoEntity toEntity(TodoDTO dto) {
		return TodoEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.done(dto.isDone())
				.build();
	}
}
