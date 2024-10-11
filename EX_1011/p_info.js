import { React, useEffect, useState } from "react";
import { call } from '../service/ApiService';
import '../style.css'
import AddProduct from "./AddProduct";
import OrderInfo from './order_info';

/*상품정보를 볼 수 있는 화면만들기
-product-react-app 이름으로 REACT프로젝트 만들기
-src에 p_info.js 만들기
-axios로 백엔드에 데이터 요청 -> 받아와서 화면에 출력
-ApiService파일의 call메서드를 사용해도 좋음*/

function P_info(){
    //상품정보를 가지고 있는 state
    const[items, setItems] = useState([])

    //상품추가 컴포넌트를 렌더링 하기위한 state
    const [open, setOpen] = useState(false);

    //내가 클릭한 라디오버튼의 index를 저장하기 위한 state
    const[selectedIndex, setSelectedIndex] = useState(null);

    //주문개수를 저장하는 state
    const [orderCount, setOrderCount] = useState(''); 

    // 주문 내역을 렌더링할지 여부를 제어하는 state
    const [showOrderInfo, setShowOrderInfo] = useState(false);

    //P_info 컴포넌트가 처음 렌더링될 대 실행됨
    useEffect(() => { //백엔드에 요청
        call("/product","GET")
        .then(result => {
            //items배열에 얻어온 데이터를 추가
            setItems(result.data);
        })
    }, [])//useEffect

    //상품추가 창을 여는 함수 작성
    const onButtonClick = ()=>{
        setOpen(true);
    }

    //상품추가 기능
    const addItem = (item) => {
        call("/product", "POST", item)
        .then(result => setItems(result.data))
    }

    //클릭한 라디오버튼의 index를 저장하는 함수 
    const handleRadioChange = (index) => {
        console.log("클릭한 index : "+ index);
        setSelectedIndex(index);
        setOrderCount('');//라디오버튼 선택시 주문 개수를 초기화
    };
    
    console.log("누른 라디오버튼 : "+selectedIndex);
    
    //주문개수의 값이 변할 때마다 state를 변경하는 함수
    const handleOrderCountChange = (event) => {
        setOrderCount(event.target.value);
    };
    
    //주문하기
    const orderProduct = () => {
        // 주문하기 전에 유효성 검사를 수행
        if (selectedIndex && orderCount > 0 && items[selectedIndex - 1]) {
            const orderData = {
                productId: items[selectedIndex- 1].productId, 
                //productId는 선택된 인덱스에서 가져옴
                productCount: parseInt(orderCount)
        };
        //DB에 추가요청을 보내고
        call("/orders", "POST", orderData)
            //items에 다시 반영
            .then(result => setItems(result.data))
        }else {//위에 if문에 표기된 조건 3개중에 뭔가가 잘못됐을 때
            alert("상품을 선택하고 주문 개수를 입력하세요.");
        }
    }
        
    // 주문 내역 버튼 클릭 시 호출되는 함수
    const showOrderDetails = () => {
        setShowOrderInfo(!showOrderInfo);  // 주문 내역을 렌더링하도록 상태 업데이트
    };

    //상품조회
    let productItems = items.length > 0 && (
        <div>
            <table border="1">
                <tbody>
                    <tr>
                        <th>단일 선택</th>
                        <th>주문 개수</th>
                        <th>상품 번호</th>
                        <th>상품 이름</th>
                        <th>상품 재고</th>
                        <th>상품 가격</th>
                        <th>등록 날짜</th>
                        <th>수정 날짜</th>
                    </tr>
                </tbody>
                {/* db에서 넘어온 상품들을 출력 */}
                {/* map함수의 특징 : index를 설정할 수 있음 */}
                {items.map((item,index) => (
                    <tbody>
                        <tr key={item.productId}>
                            <td><input type = "radio name="productId
                                onChange={() => handleRadioChange(index+1)}
                                //index : selectedIndex
                                checked={selectedIndex === index+1}/></td>
                            <td><input type="number"
                                value={selectedIndex === index + 1 ? orderCount : ''}
                                onChange={handleOrderCountChange} 
                                readOnly={selectedIndex !== index+1}/></td>
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
            <button onClick={orderProduct} >주문 완료</button>
            <button type="button" onClick="location.href='/order/list'">주문 내역</button>
        </div>
    );

        //버튼
        let addProduct = <button type="button" onClick={onButtonClick}>상품추가</button>

        //추가창
        let addProductScreen = <AddProduct setOpen={setOpen} addItem={addItem}/>

        let addButton = addProduct;

        //open이 false가 되면 상품추가 창을 연다.
        if(open){
            addProduct = <AddProduct setItems={setItems} setOpen={setOpen}/>
        }


    return(
        <div className="container">
            {addProduct}
            {productItems}
            {showOrderInfo && <OrderInfo />} {/* showOrderInfo가 참일때 주문 내역을 렌더링 */}
            
        </div>
    )

    

}//p_info

export default P_info;