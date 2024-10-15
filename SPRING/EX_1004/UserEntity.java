package com.korea.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*1. com.korea.user.model 패키지 생성
-UserEntity클래스생성
-id, name, email 필드생성
-매핑되는 테이블 이름은 user
-id는 기본키, @GeneratedValue(strategy = GenerationType.AUTO)로 값을 자동생성*/

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
/*	-GenerationType.AUTO : 데이터베이스에 따라서 자동으로 생성하는 규칙임
	-H2와 같은 내장 데이터베이스를 사용하는 경우, 기본적으로 숫자 값이 증가하는 방식으로 ID가 설정됨*/
	
    private int id;
    private String name;
    private String email;
	
	
}