package com.korea.product.dto;
/*클라이언트와 데이터를 직접적으로 주고받기 위한 DTO클래스(제네릭타입 가지고있음)*/

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	//클라이언트의 응답을 DTO에 담아서 개발자에게 보내겠다는 의미임
	
	private String error;
	private List<T>data;//List<T>data : 자동으로 ProductDTO의 리스트가 만들어짐

}
