package com.korea.product.dto;

import com.korea.product.model.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor //Builder패턴을 사용하려면 있어야 함

public class ProductDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	int id;
	double price;
	String name;
	String description;
	
    //Entity -> DTO 변환
    public ProductDTO(ProductEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.price = entity.getPrice();
    }

    //DTO -> Entity 변환
    public static ProductEntity toEntity(ProductDTO dto) {
        return ProductEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
	
}
