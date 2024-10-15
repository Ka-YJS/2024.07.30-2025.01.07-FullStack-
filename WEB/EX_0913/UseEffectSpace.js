import React, {useState, useEffect} from 'react';


function MyComponent(){
    const [count, setCount] = useState(0);

    useEffect(()=>{
        console.log(`You clicked ${count} times`)
        //()=>{} : 사이드 이펙트 함수, {}안에다가 사이드이펙트로직을 적어야함    
    },[count])//[] : 의존성 배열, count가 변경될 때마다 실행

    return(
        <div>
            <p>You Clicked {count} times</p>
            <button onClick={()=>setCount(count+1)}>Click me!</button>
        </div>
    )
    
}

export default MyComponent;