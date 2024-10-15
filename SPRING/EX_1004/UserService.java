package com.korea.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;

/*4. com.korea.user.service패키지 생성
-UserService 클래스 생성
-사용자를 생성하는 create메서드 생성
-Entity -> DTO로 바꾸기
-생성하고 추가 잘됐는지 리스트(List<UserDTO>)를 반환*/

@Service
@RequiredArgsConstructor

public class UserService {
	
	//사용자생성
	private final UserRepository repository;
	
/*	컨트롤러로부터 이름과 이메일이 담겨있는 Entity를 넘겨받음
 	-> DB에 추가 한 후, 추가가 잘 됐는지 조회를 한 데이터를 컨트롤러로 넘겨야 함*/
	public List<UserDTO> create(UserEntity entity){
		
		//데이터베이스에 저장
		repository.save(entity);
		
		//List<UserEntity> -> List<UserDTO>로 변환
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
		
	}//create
	
//=================================================================================
	
/*	6. 모든 사용자를 조회할 수 있는 API만들기
	-UserService에 getAllUsers()메서드 만들기
	-UserController : HTTP메서드는 get, 메서드명 : getAllusers( )*/
	
	//모든 사용자(유저) 조회
	public List<UserDTO> getAllUsers() {
	    // 모든 사용자 엔티티를 가져와서 DTO로 변환 후 반환
	    return repository.findAll().stream()
	            .map(UserDTO::new)  // UserEntity -> UserDTO로 변환
	            .collect(Collectors.toList());
	}
	
//=================================================================================	
	
	/*7. 이메일을 통해 사용자 검색하기

	1)UserRepository : findByEmail()
	2)UserService : getUserEmail(), UserDTO반환
	3)UserController
	-HTTP메서드 : GET
	-메서드명 : getUserByEmail( )
	-리소스 : /{emil}*/
	
	// 이메일로 사용자 검색
	public UserDTO getUserByEmail(String email) {
	    UserEntity entity = repository.findByEmail(email);
	    return new UserDTO(entity);
	}
	
		/*다른 풀이)
	 //이메일을 통한 한명의 정보 저장
	 public UserDTO getUserByEmail(String email) {
		UserEntity entity = repository.findByEmail(email);
		return new UserDTO(entity);
	}*/
	
//=================================================================================	
	
/*	8. ID를통해 이름과 이메일 수정하기

	1)UserService
	-updateUser()
	-Opional로 ID를 통해 DB에서 사용자를 찾음
	-사용자가 존재할 경우 업데이트 로직을 실행
	-수정이 잘 됐는지 전체 조회하는 메서드 반환

	2)UserController
	-HTTP메서드 : PUT
	-메서드명 : updateUser*/
	
	//사용자 정보 업데이트 (ID 기반)
	public List<UserDTO> updateUser(UserEntity entity) {
	    //Optional로 ID를 통해 DB에 저장되어 있는 객체를 찾음
	    Optional<UserEntity> userEntityOptional = repository.findById(entity.getId());
	    //userEntityOptional대신 original도 사용가능

	    //사용자가 존재할 경우 업데이트 로직 실행
	    userEntityOptional.ifPresent(userEntity -> {
	    //original : original.ifPresent(userEntity)-> 그 뒤는 같은내용
	        //이름과 이메일을 업데이트
	        userEntity.setName(entity.getName());
	        userEntity.setEmail(entity.getEmail());

	        //업데이트된 사용자 정보 저장
	        repository.save(userEntity);
	    });

	    return getAllUsers();
	}
	
	/*다른풀이)
	public List<UserDTO> original(UserEntity entity) {
	
	    Optional<UserEntity> original = repository.findById(entity.getId());
	
	    original.ifPresent(userEntity -> {
	        userEntity.setName(entity.getName());
	        userEntity.setEmail(entity.getEmail());
	
	        repository.save(userEntity);
	    });
	
	    return getAllUsers();
	}*/

//=================================================================================	
	
	/*9. ID를 가지고 유저를 삭제하는 API만들기

	1)UserService : 
	-메서드명 : deleteUser
	-삭제성공 시 true, 실패 시 false를 반환

	2)UserController : 
	-HTTP메서드 : DELETE
	-메서드명 : deleteUser
	-리소스 : /{id}*/
	
	public boolean deleteUser(int id){
		
		//id를 통해 유저가 존재하는지 먼저 확인
		Optional<UserEntity> exisist = repository.findById(id);
		
		if(exisist.isPresent()) {
			repository.deleteById(id);
			return true;
		}else {
			return false;
			
		}
	}

}//UserService
