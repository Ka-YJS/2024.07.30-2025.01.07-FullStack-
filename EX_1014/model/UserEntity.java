package com.korea.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*UserEntity : 속성
 -idx(pk)
 -id(unique)
 -pwd
 -name(진짜이름)
 -email
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="users")
public class UserEntity {

	//idx : 유저에게 부여되는 고유번호
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idx;
	//unique는 제약조건, not null 제약조건
	@Column(unique=true, nullable=false)
	private String userId;
	private String pwd;
	private String name;
	private String email;
	


}
