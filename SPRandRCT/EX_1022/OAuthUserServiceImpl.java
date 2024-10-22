package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;
import com.example.demo.persistence.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


/*DefaultOAuth2UserService : 
-시큐리티에서 기본적으로 제공하는 OAuth2로그인 시 사용자의 정보를 처리하는 서비스 클래스
-OAuth2인증이 성공하면 스프링 시큐리티는 이 클래스를 이용해 OAuth2 제공자(여기서는 github)로부터 사용자의 정보를 가져오고,
이를 기반으로 어플리케이션에서 인증된 사용자 객체를 생성함*/

@Slf4j
@Service
public class OAuthUserServiceImpl extends DefaultOAuth2UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public OAuthUserServiceImpl() {
		super( );
	}
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		//OAuth2User loadUser의 기존 loadUser를 호출함
		
		final OAuth2User oAuth2User = super.loadUser(userRequest);
		try {
			 log.info("OAuth2User attributes {} ",new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
			//writeValueAsString : json으로 직렬화함
		} catch (Exception e) {
		
		}
		
		//로그인 필드를 가져옴
		final String username = (String)oAuth2User.getAttributes().get("login");
		//현재 사용자가 어떤 OAuth2제공자를 통해 로그인을 했는지 이름을 반환함
		final String authProvider = userRequest.getClientRegistration().getClientName();
		
		UserEntity userEntity = null;
		
		//유저가 존재하지않으면 새로 생성함, existsByUsername은 실행결과가 boolean
		if(userRepository.existsByUsername(username) == false) {
			userEntity = UserEntity.builder()
							.username(username)
							.authProvider(authProvider)
							.build();
			//내용을 넣은 userEntity객체를 DB에 저장함
			userEntity = userRepository.save(userEntity);
			}
		
		log.info("Successfully pulled user info username {} authProvider {}", username, authProvider );
//		return super.loadUser(userRequest);
		return oAuth2User;
	}
	

}
