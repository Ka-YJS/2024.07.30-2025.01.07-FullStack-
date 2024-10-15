package com.korea.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.service.UserService;

import lombok.RequiredArgsConstructor;

/*5. com.korea.user.controller패키지 생성
-UserController클래스 생성
-HTTP메서드 : POST
-메서드명 : createUser
-사용자에게 추가하기 위한 이름과 이메일을 받아서 추가함*/

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
	
	private final UserService userService;
	
	//User생성
	@PostMapping
	public ResponseEntity<List<UserDTO>> createrUser(@RequestBody UserDTO dto){
		
		//서비스로 보내기 위해서 DTO -> Entity로 바꿈
		UserEntity entity = UserDTO.toEntity(dto);
		List<UserDTO> users = userService.create(entity);
		return ResponseEntity.ok(users);
		
	}//List
	
//=================================================================================
	
	/*	6. 모든 사용자를 조회할 수 있는 API만들기
	-UserService에 getAllUsers()메서드 만들기
	-UserController : HTTP메서드는 get, 메서드명 : getAllusers( )*/
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers() {
	    List<UserDTO> users = userService.getAllUsers();
	    return ResponseEntity.ok().body(users);
	}
	
//=================================================================================
	
	/*7. 이메일을 통해 사용자 검색하기

	1)UserRepository : findByEmail()
	2)UserService : getUserEmail(), UserDTO반환
	3)UserController
	-HTTP메서드 : GET
	-메서드명 : getUserByEmail( )
	-리소스 : /{emil}*/
	
	//사용자 정보 수정 (ID 기반)
	// 이메일로 사용자 검색
	@GetMapping("/{email}")
	public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
	    UserDTO user = userService.getUserByEmail(email);
	    return ResponseEntity.ok(user);
	}
	
	/*다른풀이)
	//이메일을 통한 한명 조회하기
	@GetMapping
	public Repository<?>getUserEmail(@PathVariavle String email){
		UserDTO user = service.getUserByEmail(email);
		return RepositoryEntity.ok(user);
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
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody UserDTO dto) {
	    UserEntity entity = UserDTO.toEntity(dto); //dto -> entity
	    List<UserDTO> updatedUser = userService.updateUser(entity);//entity -> dto

	    return ResponseEntity.ok().body(updatedUser);
	    }
	
//=================================================================================	
	
	/*9. ID를 가지고 유저를 삭제하는 API만들기

	1)UserService : 
	-메서드명 : deleteUser
	-삭제성공 시 true, 실패 시 false를 반환

	2)UserController : 
	-HTTP메서드 : DELETE
	-메서드명 : deleteUser
	-리소스 : /{id}
	-삭제가 잘되면 "User deleted successfully"
	-삭제가 잘 안되면 404상태 만들고, "User not found with id"+id*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteUser(@PathVariable int id){
		boolean isDeleted = userService.deleteUser(id);
		
		if(isDeleted) {
			return ResponseEntity.ok("User deleted successfully");
		}else {
			return ResponseEntity.status(404).body("User not found with id"+id);
		}
	}
	

}//UserController
