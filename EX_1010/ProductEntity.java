package com.korea.product.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="product")
//"product" = ProductEntity라는 의미로, product라는 테이블이 있으면 ProductEntity와 매핑시키겠다는 의미임
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;//상품Id, primary key
	private String productName;//상품이름
	private int productStock;//상품재고
	private int productPrice;//상품가격
	
	//LocalDateTime은 java.time에서 제공해주는 것으로 시간을 저장해줌, String으로 써도 상관없음

	@CreationTimestamp//:Insert쿼리가 발생했을 때 시간 값을 적용시켜줌
	private LocalDateTime registerDate;//등록날짜
	
	@UpdateTimestamp//:Update쿼리가 발생했을 때 시간 값을 적용시켜줌
	private LocalDateTime updateDate = LocalDateTime.now();//수정날짜
	//LocalDateTime.now( ) : 현재시간을 저장해줌
	
}
