package com.korea.product.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.korea.product.model.ProductEntity;
//다른패키지에 있으므로 import해줘야 함

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	//id타입은 int인데 int는 기재할 수 없으므로 Integer를 사용함
	//JpaRepository : 메서드를 귀현하지않고 직접 호출하여 사용할 수 있음
}
