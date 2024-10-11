package com.korea.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.product.dto.OrderDTO;
import com.korea.product.dto.ProductDTO;
import com.korea.product.dto.ResponseDTO;
import com.korea.product.service.OrderService;

import lombok.RequiredArgsConstructor;

/*OrderController클래스
 -OrderService주입
 -mapping : orders
 
 -HTTP 메소드 : GET
 -리소스 : total
 -메서드명 : getAllOrderTotals( )*/

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@GetMapping("total")
	public ResponseEntity<?> getAllOrderTotals( ){
		List<OrderDTO>list = orderService.getAllOrderTotalPrices();
		ResponseDTO<OrderDTO>response = ResponseDTO.<OrderDTO>builder().data(list).build();
	
		return ResponseEntity.ok().body(response);
	}//@GetMapping
	
	 @PostMapping
	  public ResponseEntity<?> saveOrder(@RequestBody OrderDTO dto){
	  List<ProductDTO> list = orderService.save(dto);
	  ResponseDTO<ProductDTO> response = ResponseDTO.<ProductDTO>builder().data(list).build();
	  
	  return ResponseEntity.ok().body(response);
	  
	 }//@PostMapping

	
	
	
	
	
}
