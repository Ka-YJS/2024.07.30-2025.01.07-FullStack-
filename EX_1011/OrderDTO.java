package com.korea.product.dto;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*주문내역을 조회할 때, 총 결제금액까지 보여줄 것임
 -속성 : 주문번호, 상품번호, 상품이름, 주문개수, 상품가격, 결제금액, 주문날짜*/

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	
	private int orderId;//주문번호(ID)
	private int productId;//상품번호(ID)
	private String productName;//상품이름
	private int productCount;//주문개수
	private int productPrice;//상품가격
	private int totalPrice;//결제금액(=주문개수 * 상품가격)
	private String orderDate;//주문날짜
	
	public static List<OrderDTO>toListOderDTO(List<Object[ ]>list) {
		//Object[ ]데이터를 OrderDTO로 변환, 요소의 개수는 OrderRepository안에 요소의 개수
		//앞에 자료형을 쓰는 이유 : int를 예시로 들자면, Object -> Integer -> int의 과정이 진행되는데 이 과정을 언박싱이라고함
		return list.stream( ).map(result -> OrderDTO.builder()
									.orderId((int)result[0])
									.productName((String)result[1])
									.productCount((int)result[2])
									.productPrice((int)result[3])
									.totalPrice((int)result[4])
									.orderDate((String)result[5])
									.build()).collect(Collectors.toList());

	}

}