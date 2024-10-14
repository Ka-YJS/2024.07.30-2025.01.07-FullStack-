package com.korea.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.persistence.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*1. 회원추가
	 -id : 중복되는게 있는지 먼저 검증
	 -pwd
	 -name
	 -email
	 
	 1_1. id중복체크 메서드 만들기 -> 메서드명 : boolean isIdDuplicated(String id)
	 1_2. 회원추가 -> 메서드명 : List<UserDTO>insert(UserDTO dto)
	 */
	
	/*id 중복체크메서드 : id를 db로 전달해서 조회하면 false, 조회안되면 true를 반환
	 *true면 아이디 생성가능, false면 아이디생성 불가능
	 */

	public boolean isIdDuplicate(String id) {
		Optional<UserEntity> user =  userRepository.findByUserId(id);
		return !user.isPresent( );//조회되면 true
	}
	
	//2. 회원가입메서드
	public List<UserDTO> insert(UserDTO dto){
		
		//dto -> entity
		UserEntity entity = UserDTO.toEntity(dto);
		
		//entity를 DB에 저장
		userRepository.save(entity);
		
		//List<UserEntity> -> List<UserDTO>
		return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
		
	}
	
	//유저전체조회
	public List<UserDTO>allUsers(){
		List<UserDTO> list = userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
		return list;
	}
	
	
	//로그인 -> 아이디랑 비밀번호를 받음
	public UserEntity getByCredential(String userId, String pwd) {
		return userRepository.findByUserIdAndPwd(userId, pwd);
	}
	
	
	
	
	
	
}
