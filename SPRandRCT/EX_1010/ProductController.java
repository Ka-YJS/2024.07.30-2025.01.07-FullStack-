package com.korea.product.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.dto.ResponseDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RequestMapping("product")
@RestController
@RequiredArgsConstructor//final을 사용하면 반드시 넣어줘야 함
public class ProductController {
	
	//ProductService주입하기(생성자주입)
		private final ProductService productService;
		
/*	  private final ProductService productservice; + @RequiredArgsConstructor는 아래와 같이 볼 수 있음
	 *public ProductController(ProductService productservice) {
			this.productservice = ProductService;
		} -> 간단하게 생성자를 생성하기위해서 사용함*/
		
		/* 상품조회하기
		 -데이터베이스에 들어있는 모든 상품을 조회하는 API만들기
		 -결과는 ResponseDTO에 담아서 보내기
		 -HTTP Method : GET*/
		@GetMapping
		public ResponseEntity<?>productList(){
			List<ProductDTO>dtos = productService.findAll();
			ResponseDTO<ProductDTO> response = ResponseDTO.<ProductDTO>builder().data(dtos).build();
					
			return ResponseEntity.ok().body(response);
		}//@GetMapping
		
		/*상품추가하기
		 -클라이언트로부터 데이터를 넘겨 받아서 DB에 데이터 추가하기
		 -모든데이터를 반환하기
		 -HTTP Method : POST
		 -메서드명 : createProduct*/
		@PostMapping
		public ResponseEntity<?>createProduct(@RequestBody ProductDTO dto){
			List<ProductDTO> dtos = productService.create(dto);
			ResponseDTO<ProductDTO>response = ResponseDTO.<ProductDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
			
		}//@PostMapping

		

}
