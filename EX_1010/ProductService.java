package com.korea.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.product.dto.ProductDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	//ProductRepository주입하기(생성자주입)
	private final ProductRepository productRepository;
	
	//상품조회하는 기능만들기
	public List<ProductDTO> findAll(){
		//DB에 접근해서 데이터를 조회함
		//findAll( ): select * from product;
		List<ProductEntity>list =  productRepository.findAll();
		//리스트안에 들어있는 Entity들을 DTO로 변경함
		List<ProductDTO>dtos = list.stream().map(ProductDTO::new).collect(Collectors.toList());
		return dtos;}
	
	//상품추가하는 기능만들기
	public List<ProductDTO> create(final ProductDTO dto){
		//dto->entity 작업수행
		ProductEntity entity = ProductDTO.toEntity(dto);
		//넘어온 데이터를 데이터베이스에 추가함
		productRepository.save(entity);
		//다시 조회해서 반환
		return findAll();

	}
	

}
