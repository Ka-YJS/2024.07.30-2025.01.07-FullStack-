import React from 'react';
import { useState} from 'react';
import {call} from '../service/ApiService'

function AddProduct(props){

    let setItems = props.setItems;

    //상품의 정보를 저장할 수 있는 state
    const[product,setProduct]=useState({productName:'',productStock:0,productPrice:0})

    const {productName,productStock,productPrice} = product;
    
    const onChange = (e) => {    
        //e.target(이벤트가 일어난 대상)에서 name과 value를 추출
        const { value, name } = e.target;     
        setProduct({      
            ...product, //기존의 input 객체를 복사한 뒤      
            [name]: value //name 키를 가진 값을 value 로 설정
        //[]를 쓰는 이유 : []가 없으면 값이 name으로만 고정되어서 위에 상품정보를 넣을 수 없음 
            });  
        };

    //등록버튼 눌렀을 때 input태그에 들어있는 정보를 boot으로 보냄
    const onButtonClick = () => {
        call("/product","POST",product)
        .then(result => {setItems(result.data)})

        //입력필드 초기화함수
        setProduct({ productName: "", productStock: 0, productPrice: 0 });
        
        //입력창 닫기
        props.setOpen(false);
    }    
    
    return(
        <div className="register-wrap" style={{width:'500px'}}>
			<div><input style={{width: '98%'}} value={productName} 
                onChange={onChange} name='productName' placeholder="상품 이름"/></div>
			<div><input style={{width: '98%'}} value={productStock} 
                onChange={onChange} name='productStock' placeholder="상품 재고"/></div>
			<div><input style={{width: '98%'}} value={productPrice} 
                onChange={onChange} name='productPrice' placeholder="상품 가격"/></div>
			<input type="button" value="등록" onClick={onButtonClick} style={{width:'100%'}} />
		</div>
    )
}

export default AddProduct;