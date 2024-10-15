import React, {useEffect, useState} from 'react';

function Sol3(){
    const [count, setCount] = useState(0);
    const [renderCount, setRenderCount] = useState(0);

    const clickhandler = () => {
        setCount(count + 1);
    };

    useEffect(() => {
        setRenderCount(renderCount + 1);
        console.log("렌더링 완료");
    },[count]);//:카운트가 바뀔때마다 랜더링하겠다라는 의미임

    return(
        <div>
            <h1>Count : {count}</h1>
            <h1>렌더링 횟수 : {renderCount}</h1>
            <button onClick={clickhandler}>클릭</button>
        </div>
    );
};

export default Sol3;