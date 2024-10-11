package com.korea.product.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* 주문하기
 -com.korea.product.model에 OrderEntity생성
 -속성 : 주문번호(PK), 상품번호, 주문개수, 주문날짜(insert될 때의 시간)*/

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue//:enum으로, 상수들의 집합
	private int orderId;//주문번호
	
	@ManyToOne//ProductEntity와 다대일 관계를 설정함
	@JoinColumn(name="productId", nullable=false)
	private ProductEntity product;//상품번호
	
	private int productCount;//주문개수
	
	@CreationTimestamp
	private String orderDate;//주문날짜

}
