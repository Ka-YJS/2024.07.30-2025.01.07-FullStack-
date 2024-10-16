package com.korea.product.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.product.dto.ProductDTO;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductService {
	
	
	private final ProductRepository repository;
	
	//상품추가
	public ProductDTO addProduct(ProductDTO productDTO) {
		
		//넘어온 DTO를 Entity로 변환
		ProductEntity entity = ProductDTO.toEntity(productDTO);
		
		//Entity를 DB에 추가하고, DTO로 변환하여 반환
		return new ProductDTO(repository.save(entity));
		
	}
	
/*	   //상품추가
	   public List<ProductDTO> addProduct() {
	      List<ProductEntity> list = Arrays.asList(
	                new ProductEntity(1, "Smartphone", "High-end smartphone with 128GB storage", 999.99),
	                new ProductEntity(2, "Laptop", "15-inch laptop with 16GB RAM and 512GB SSD", 1299.99),
	                new ProductEntity(3, "Wireless Earbuds", "Noise-cancelling wireless earbuds", 199.99),
	                new ProductEntity(4, "Smartwatch", "Fitness tracker with heart rate monitor", 249.99),
	                new ProductEntity(5, "Gaming Mouse", "High-precision gaming mouse with RGB lighting", 59.99),
	                new ProductEntity(6, "Bluetooth Speaker", "Portable Bluetooth speaker with 12-hour battery life", 79.99),
	                new ProductEntity(7, "4K TV", "55-inch 4K Ultra HD TV with HDR support", 899.99),
	                new ProductEntity(8, "Tablet", "10-inch tablet with 64GB storage", 299.99),
	                new ProductEntity(9, "External Hard Drive", "2TB external hard drive for backups", 89.99),
	                new ProductEntity(10, "Gaming Console", "Next-gen gaming console with 1TB storage", 499.99)
	        );
	      for(int i = 0; i<list.size(); i++) {
	         repository.save(list.get(i));
	      }
	      
	      return list.stream().map(ProductDTO::new).collect(Collectors.toList());
	   }*/
	
    //필터링된 상품 조회
    public List<ProductDTO> getFilteredProducts(Double minPrice, String name) {
        List<ProductEntity> products = repository.findAll();

        //가격 필터링 (minPrice가 있을 경우)
        if (minPrice != null) {
            products = products.stream()
                    .filter(product -> product.getPrice() >= minPrice)
                    .collect(Collectors.toList());
        }

        //이름 필터링 (name이 있을 경우)
        if (name != null && !name.isEmpty()) {
            products = products.stream()
                    .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }

        return products.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    //상품 수정
    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        Optional<ProductEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            ProductEntity entity = optionalEntity.get();
            entity.setName(productDTO.getName());
            entity.setDescription(productDTO.getDescription());
            entity.setPrice(productDTO.getPrice());
            repository.save(entity);
            return new ProductDTO(entity);
        }
        return null;
    }

    //상품 삭제
    public boolean deleteProduct(int id) {
        Optional<ProductEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
        	repository.deleteById(id);
            return true;
        }
        return false;
    }
	

}//ProductService