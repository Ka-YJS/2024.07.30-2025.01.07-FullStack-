package com.korea.product.service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

/*OrderService클래스
 -OrdeerRepository를 주입
 
 주문조회
 -메서드명 : getAllOrderTotalPrices( )
 
 클라이언트로부터 productId와 productCount를 전달받아 주문테이블에 주문내역 추가하기
 -상품이 존재하는지 먼저 확인
 -재고를 확인
 -주문하기
 -재고감소
 -전체목록반환하기
 -메서드명 : save( )
 */

import org.springframework.stereotype.Service;

import com.korea.product.dto.OrderDTO;
import com.korea.product.dto.ProductDTO;
import com.korea.product.model.OrderEntity;
import com.korea.product.model.ProductEntity;
import com.korea.product.persistence.OrderRepository;
import com.korea.product.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	private final ProductRepository productRepository;
	
	//주문내역 조회하기
	/*-한건의 데이터 -> 한건의 엔티티 객체
	  -2개이상의 데이터가 조회될 수도 있음
	  -하나의 메서드는 하나의 값만 반환할 수 있음*/
    public List<OrderDTO> getAllOrderTotalPrices() {
        //DB에 접근해서 JPQL 쿼리로 반환된 List<Object[ ]> 데이터를 받아옴
        List<Object[ ]> list = orderRepository.findAllOrderTotalPrices();
        
        //List<OrderDTO>와 반환값을 맞춰야함
		return OrderDTO.toListOderDTO(list);
	
    }//getAllOrderTotalPrices
    
    //주문하기 기능
    public List<ProductDTO>save(OrderDTO dto){
    	//상품이 존재하는지 먼저 확인(select * from Product;)
    	Optional<ProductEntity>option = productRepository.findById(dto.getProductId());
    	ProductEntity productEntity;
    	
    	//상품이 조회가 되면
    	if(option.isPresent()){
    		productEntity = option.get();//엔티티를 저장함
    	}else {
    		//IllegalArgumentException : 잘못된 또는 부적절한 인수가 메서드에 전달됐을 때 발생하는 예외
    		throw new IllegalArgumentException("상품을 찾을 수 없음");
    	}
    	
    	//재고확인
    	if(productEntity.getProductStock() < dto.getProductCount()) {
    		throw new RuntimeException("재고 부족. 현재 재고 : "+productEntity.getProductStock());
    	}
    	
        //주문하기
        OrderEntity order = OrderEntity.builder()
                .product(productEntity)
                .productCount(dto.getProductCount())
                .build();
        
    	 //DB에 주문내역 저장
        orderRepository.save(order);
        
    	//재고감소
    	productEntity.setProductStock(productEntity.getProductStock() - dto.getProductCount());
    	productRepository.save(productEntity);
    	List<ProductDTO> dtos = productRepository.findAll().stream()
    									.map(entity -> new ProductDTO(entity))
    									.collect(Collectors.toList());
    	return dtos;
    	
    	}
 
}
