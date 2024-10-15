package com.korea.user.dto;

import com.korea.user.model.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 2. com.korea.user.dto 패키지 생성
-UserDTO 클래스 생성
-id, name, email 필드 생성
-DTO에서 Entity, Entity에서 DTO로 변환하는 기능을 갖고있음*/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
	
    private int id;
    private String name;
    private String email;
    
    //Entity -> DTO
	public UserDTO(UserEntity entity) {
	/*	*final
		-final을 붙이면 상수가 되고, 값을 넣으면 값변경이 불가능함
		-생성자 내에서 한번만 실행되고, 이후 변경할 수 없음
		-entity의 다른 값을 할당할 수 없음*/
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
	}//UserDTO
	
	//DTO -> Entity
	public static UserEntity toEntity(UserDTO dto) {
		return UserEntity.builder()
				.id(dto.getId())
				.name(dto.getName())
				.email(dto.getEmail())
				.build();
	}//UserEntity

}
