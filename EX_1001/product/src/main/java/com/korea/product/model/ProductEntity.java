package com.korea.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor //JPA에서 Entity객체를 데이터베이스에서 조회하려고할 때, 없으면 문제가 발생할 수 있음
@AllArgsConstructor
@Table(name="products")

public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	int id;
	double price;
	String name;
	String description;
	
	
	
	
}
