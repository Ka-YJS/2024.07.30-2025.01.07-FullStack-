import { React, useEffect, useState } from "react";
import { call } from './service/ApiService';
import './styles.css'
import AddProduct from './AddProduct';

/*상품정보를 볼 수 있는 화면만들기
-product-react-app 이름으로 REACT프로젝트 만들기
-src에 p_info.js 만들기
-axios로 백엔드에 데이터 요청 -> 받아와서 화면에 출력
-ApiService파일의 call메서드를 사용해도 좋음*/

function P_info(){
    //상품정보를 가지고 있는 state
    const[items, setItems] = useState([])

    //추가창을 띄위는 state
    const [open, setOpen] = useState(true);

    useEffect(() => { //백엔드에 요청
        call("/product","GET")
        .then(result => {
            setItems(result.data);
        })
    }, [])//useEffect

    //onButtonClick함수 작성
    const onButtonClick = ()=>{
        setOpen(false);
    }


    let productItems = items.length > 0 && (
        <table border="1">
            <tbody>
                <tr>
                    <th>상품 번호</th>
                    <th>상품 이름</th>
                    <th>상품 재고</th>
                    <th>상품 가격</th>
                    <th>등록 날짜</th>
                    <th>수정 날짜</th>
                </tr>
            </tbody>
            {/* db에서 넘어온 상품들을 출력 */}
            {items.map(item => (
                <tbody>
                    <tr>
                        <td>{item.productId}</td>
                        <td>{item.productName}</td>
                        <td>{item.productStock}</td>
                        <td>{item.productPrice}</td>
                        <td>{item.registerDate}</td>
                        <td>{item.updateDate}</td>
                    </tr>
                </tbody>
            ))}
            
            {/* db에서 넘어온 상품들을 출력 */}
        </table>
    );

        //버튼
        let addProduct = <button type="button" onClick={onButtonClick}>상품추가</button>

        //추가창
        let addProductScreen = <AddProduct />
    
        let addButton = addProduct;
    
        //open이 false가 되면 상품추가 창을 연다.
        if(!open){
        addButton = addProductScreen;
        }

    return(
        <div className="container">
            {addButton}
            {productItems}
            
        </div>
    )

    

}//p_info

export default P_info;