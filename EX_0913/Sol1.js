import React, {useState} from 'react';

function Sol1(){//1. 컴포넌트 만들기
    const [eating, SetEating] = useState(['초콜릿','사탕'])
    const [value, SetValue] = useState("");
    //const [text, SetText] = useState('');


    //4. inputHandler 작성하기 -> value의 값을 변경함
    const inputHandler = (e) => {
        SetValue(e.target.value)
        //SetValue("");
    }

    //6. clickHandler 작성하기 -> 버튼을 클릭했을 때 value를 eating에 추가함
    const clickHandler = () => {
        SetEating(prev => [value, ...prev])
        //prev : 이전결과값을 누적적용하여 출력됨, state : 현재 실행값만 출력됨
    }
    return (
        <div>
            {/* 2. return작성 
            <input>
                <button>추가</button>
            </input>
            <ur>{eating.map((item,idx) =>(
                    <li key={idx}>{item}</li>
                ))}</ur> */}
            <input onChange={inputHandler} type="text"/>
            {/* <input onChange={inputHandler} value={value}/>
                -> //한부분 추가하고싶으면 이렇게 써야함*/}
            {/* 5. input 내용 변경하기 */}
            <button onClick={clickHandler}>추가</button>
            <ul>
                {eating.map((item,idx) =>(
                    <li key={idx}>{item}</li>// : list가 button의 횟수만큼 생김
                ))}
            </ul>
        </div>
    )
}

export default Sol1;