package com.korea.product.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.ProductDTO;
import com.korea.product.service.ProductService;

@RestController
@RequestMapping("/api/products")

public class ProductController {
	
/*	private final ProductService service = null;
	
	//상품추가하기
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO dto) {
    	
        ProductDTO createProduct = service.addProduct(dto);
        return ResponseEntity.ok().body(createProduct);
    }*/
	
    @Autowired
    private ProductService service;

    // 상품 추가
    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = service.addProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }
    
/*    @PostMapping
    public ResponseEntity<?> addProduct(){
       return ResponseEntity.ok().body(service.addProduct());
    }*/
    
    //모든 상품 조회 (쿼리 파라미터로 필터링 가능)
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "name", required = false) String name) {
        List<ProductDTO> products = service.getFilteredProducts(minPrice, name);
        return ResponseEntity.ok(products);
    }
    
/*    @GetMapping
    public RespionseEntity<?>getFilteredProduct(
    		@RequseParam(value="minPrice", required=false) Double minPirce,
    		@RequseParam(value="name", required=false) String name{
    			List<ProductDTO>products = service.getFilteredProductsd(minPrice,name);
    			returnd ResponseEntity.ok().body(product);
    		}*/
    		

    //상품 수정
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProduct = service.updateProduct(id, productDTO);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }
        return ResponseEntity.notFound().build();
    }

    //상품 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        boolean isDeleted = service.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    

}//ProductController
