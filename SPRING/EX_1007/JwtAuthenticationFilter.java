package com.example.demo.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private TokenProvider tokenProvider;
	
	//doFilterInternal() : 스프링 시큐리티의 OncePerRequestFilter를 상속받은 메서드로, 한 요청에 대해 한 번만 실행되도록 보장된다.
	@Override						//요청, 응답, 필터체인을 받음
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {//필터에서 뭘 하고싶은지를 작성함 -> 토큰을 가지고 유효한지 검증함
		try {//1. 발급된 토큰 읽어오기
			
			/* *parseBearerToken 메서드 : 
			-HTTP 요청 헤더에서 Authorization 값을 가져와 Bearer 토큰 형식인지 확인한 후, 토큰 값을 반환함
			토큰이 없거나 유효하지 않으면 null을 반환함
			- request에 담긴 토큰을 꺼내는 메서드*/
			String token = parseBearerToken(request);
			
			log.info("Filter is running...");

			//2. 토큰 검사하기 : JWT이므로 인가 서버에 요청하지 않고도 검증 가능
			if(token != null && !token.equalsIgnoreCase("null")) {
				//userId 가져오기 -> 위조된 경우 예외처리함 -> TokenProvider에서 토큰을 검증(validateAndGetUserId)하고 userId를 가져옴
				String userId = tokenProvider.validateAndGetUserId(token);
				log.info("Authenticated user ID : " + userId);

				//사용자 인증 완료 후, SecurityContext에 인증 정보를 등록
				
				//인증 완료; SecurityContextHolder에 등록해야 인증된 사용자라고 생각함

				/*AbstractAuthenticationToken :
				-스프링 시큐리티에서 인증된 사용자 정보를 표현하는 Authentication 객체의 추상 클래스임
				-인증된 사용자와 그 사용자의 **권한 정보(Authorities)**를 담는 역할을 함*/

				/*UsernamePasswordAuthenticationToken
				사용자 이름과 비밀번호를 사용하여 인증을 처리할 때 사용하는 구현 클래스임*/
				AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
																		(userId, //id
																		null, //password -> 굳이 저장안해도돼서 null값으로 지정
																		AuthorityUtils.NO_AUTHORITIES // 현재 권한 정보는 제공하지 않음
																		);//이 3가지가 Principal이라고 볼 수 있음
				/*
				 -
				 -
				 -
				 */
				
			/* 1)WebAuthenticationDetailsSource : 
				-스프링 시큐리티에서 제공하는 클래스임
				-HttpServletRequest 객체의 request로부터 인증 세부 정보(Authentication Details)를 생성하는 역할을 함
				
				2)buildDetails(request) 메서드 : 
				-HttpServletRequest 객체에서 인증과 관련된 추가적인 정보를 추출해 WebAuthenticationDetails 객체를 생성함
				-추가적인 정보는 일반적으로 사용자의 세션 ID, 클라이언트 IP 주소 등의 메타데이터를 포함함*/
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

			/* 3)SecurityContext : 
				-SecurityContext를 생성하고 인증된 정보를 저장함
				-스프링 시큐리티에서 사용자의 인증 정보와 보안 컨텍스트를 관리하는 중심 클래스임
				-애플리케이션 내에서 현재 인증된 사용자의 정보를 저장하고 제공하는 역할을 함*/
				SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

			/*	4)setAuthentication(authentication) : 
				-현재 요청에 대한 인증 정보를 SecurityContext에 저장하여 
				스프링 시큐리티가 해당 사용자를 인증된 사용자로 인식하게 하는 메서드임*/
				securityContext.setAuthentication(authentication);

				//인증을 완료한 후, 이 메서드를 사용하여 인증된 사용자 정보를 저장할 수 있음
				SecurityContextHolder.setContext(securityContext);
			}
		} catch (Exception e) {
			logger.error("Could not set user authentication in security context", e);
		}
		filterChain.doFilter(request, response);//다음필터가 있으면 호출해라 라는 의미임
	}//doFilterInternal
	
	/*HttpServletRequest request : 클라이언트가 하는 요청은 request객체에 담김
		-> 고객의 요청을 읽고, Authorization부분을 자르고 그 안에서 다시 토큰부분만 잘라서 반환함*/
	private String parseBearerToken(HttpServletRequest request) {
		//Http 요청의 헤더를 파싱해 Barer 토큰을 반환함
		String bearerToken = request.getHeader("Authorization");
		
		// Bearer 토큰 형식일 경우 토큰 값만 반환함
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			return bearerToken.substring(7);//토큰부분만 잘라서 반환함
		}
		return null;
	}

}
