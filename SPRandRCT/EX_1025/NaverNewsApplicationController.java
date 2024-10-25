package com.korea.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class NaverNewsApplicationController {

	private final WebClient webClient;
	
	@Value("${naver.client.id}")
	private String clientId;
	
	@Value("${naver.client.secret}")
	private String clientSecret;
	
	public NaverNewsApplicationController(WebClient.Builder webClient) {
		this.webClient = webClient.baseUrl(
				"https://openapi.naver.com/v1/search")
				.build();
	}
	
	@GetMapping("/api/news")
	public Flux<String> searchBooks(@RequestParam String query){
		System.out.println("query : " + query);
		return webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/news.json")
						.queryParam("query", query)
						.build())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.header("X-Naver-Client-Id", clientId)
				.header("X-Naver-Client-Secret", clientSecret)
				.retrieve()
				.bodyToFlux(String.class);		
	}
}







