package com.example.demo.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class ApplicationOAuth2User implements OAuth2User {

	private String id;
	private Collection<? extends GrantedAuthority> authorities;
	private Map<String, Object> attributes;
	
	
	public ApplicationOAuth2User(String id, Map<String, Object> attributes) {
		this.id = id;
		this.attributes = attributes;
		this.authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	/*	-SimpleGrantedAuthority라는 객체생성 + 사용자가 "ROLE_USER"라는 권한을 갖고있음
		-ROLE_ : 권한을 줄 때 이렇게 사용함
		-singletonList( ) : 단일 요소를 포함하는 불변 리스트를 생성함
							여기서는 new SimpleGrantedAuthority("ROLE_USER")라는 하나의 권한 객체를 담고있는
							리스트를 생성하는데 사용됨*/
		
	}


	@Override
	public Map<String, Object> getAttributes() {
		return this.attributes;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}


	@Override
	public String getName() {
		return this.id;//name대신 id를 반환함
	}
	
	
	
	
	
	
	
	
}
