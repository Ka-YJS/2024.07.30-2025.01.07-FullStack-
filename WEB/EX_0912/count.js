import React, {useState} from 'react';

function Example(){
    const [count, setCount] = useState(0);
    /*0이 첫번째 값으로 들어감
    새로고침전까지는 값 유지 -> 새로고침하면 다시 0이 값으로 들어가서 초기화됨*/
    /*배열 구조분해 : 
    const [count, setCount] = useState(0);을 풀어쓰면 아래와 같음

    let countArray = useState(0);
    let count=countArray[0];
    let setCount=countArray[1];

    */ 
    return(
        <div>
            <p>clicked {count} times</p>
            <button onClick={()=>setCount(count+1)}>Click me</button>
            {/* 값을 누르면 count값을 변화시키고, Example 컴포넌트에 넘기며 재렌더링을 함 */}
        </div>
    )
}
export default Example;