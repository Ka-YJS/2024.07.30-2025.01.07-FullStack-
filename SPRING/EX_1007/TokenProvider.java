package com.example.demo.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//토큰을 생성하는 메서드 -> 유저의 정보를 받아서 JWT생성하기
public class TokenProvider {
	private static final String SECRET_KEY = "eyJhbGciOiJIUzUxMiJ9eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTcyNzk3NzQ2OSwiaWF0IjoxNzI3OTc3NDY5fQ3WUk1X983GsejnQZJSNQKjZBfBeSzOK4cAxpndz0G3pSItFPDiDVnSfD0ZsQzVCSkSMKQozyMVDjt9VYTcJw";

	public String create(UserEntity userEntity) {
		//토큰의 유효날짜를 1일로 설정
		Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
		/*코드설명
		-Date expiryDate : 토큰의 유효날짜
		-Date.from( ) : Instant객체를 Date객체로 변환하는 메서드
		-Instant.now( ) : 현재 기준의 시간을 날짜와 시간을 초 단위로 표현함
		-plus(1, ChronoUnit.DAYS) : Instant객체에 하루를 더하는 동작임*/

		/*
		{ //header
		  "alg":"HS512"
		}.
		{ //payload
		  "sub":"40288093784915d201784916a40c0001",
		  "iss": "demo app", -> 토큰을 발행하는 주체
		  "iat":1595733657,
		  "exp":1596597657
		}.
		// SECRET_KEY를 이용해 서명한 부분(시그니처)
		Nn4d1MOVLZg79sfFACTIpCPKqWmpZMZQsbNrXdJJNWkRv50_l7bPLQPwhMobT4vBOG6Q3JYjhDrKFlBSaUxZOg
		 */
		
		
		//JWT Token 생성_jjwt라이브러리를 사용함
		return Jwts.builder()
						//signWith : header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
						.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
						//payload에 들어갈 내용
						.setSubject(userEntity.getId()) //sub
						.setIssuer("demo app") //iss -> 토큰 발행 주체
						.setIssuedAt(new Date()) //iat -> 토큰 발행 날짜
						.setExpiration(expiryDate) //exp
						.compact();//토큰을 .으로 구분된 하나의 문자열로 만들어줌
	}
	
	//토큰을 받아서 검증하는 메서드
	public String validateAndGetUserId(String token) {
		/*.setSigningKey(SECRET_KEY)
		-토큰을 생성할 때 사용했던 서명키
		-parseClaimsJws메서드가 Base 64로 디코딩 및 파싱(읽어옴)
		-즉, 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용 해 서명 후, token의 서명 과 비교
		-위조되지 않았다면 페이로드(Claims) 리턴
		-그 중 우리는 userId가 필요하므로 getBody를 부름*/
		Claims claims = Jwts.parser()
						.setSigningKey(SECRET_KEY)
						.parseClaimsJws(token)
						/*parseClaimsJws(token)
						-payload부분을 반환함
						-여기에는 주체, 발행자, 만료시간, 발행시간 등 여러가지 필드가 있을 수 있음*/
						.getBody();

		return claims.getSubject();
		/*getSubject()
		-claims객체에서 주체를 가져옴
		-주로 사용자의 id나 이름같은 식별자를 나타냄 -> username
		-이 값은 JWT를 발급할 때 설정된 것임*/
	}
}