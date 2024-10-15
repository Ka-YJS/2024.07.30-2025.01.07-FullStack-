package com.korea.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import com.korea.user.model.UserEntity;

/*3. com.korea.user.persistence패키지 생성
-UserRepository인터페이스 생성
-JpaRepository 상속받기*/

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	/*7. 이메일을 통해 사용자 검색하기

	1)UserRepository : findByEmail()
	2)UserService : getUserEmail(), UserDTO반환
	3)UserController
	-HTTP메서드 : GET
	-메서드명 : getUserByEmail( )
	-리소스 : /{emil}*/
	
	//추가적으로 사용자 검색 기능이 필요하면 메서드를 정의할 수 있음
	UserEntity findByEmail(String email);

}
