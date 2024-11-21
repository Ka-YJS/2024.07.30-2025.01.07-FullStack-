package com.korea.board.DTO;

import com.korea.board.Entity.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	
	private Long id;
	private String title;
	private String author;
	private String writingTime;
	private String content;
	
	//Entity -> DTO
	public BoardDTO(final BoardEntity entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.writingTime = entity.getWritingTime();
		this.content = entity.getContent();
	}
	
	//DTO -> Entity
	public static BoardEntity toentity(BoardDTO dto) {
		return BoardEntity.builder()
				.id(dto.getId())
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.writingTime(dto.writingTime)
				.content(dto.getContent())
				.build();
	}

}
