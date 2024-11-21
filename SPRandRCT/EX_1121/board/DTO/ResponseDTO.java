package com.korea.board.DTO;

import lombok.Data;

@Data
public class ResponseDTO<T> {
	
	private String error;
	private T data;

}
