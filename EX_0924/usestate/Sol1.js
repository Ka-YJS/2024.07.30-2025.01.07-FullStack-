import React, {useState} from 'react';

function Sol1(){
    const [ eating, SetEating] = useState(['초콜릿','사탕'])
    const[value, SetValue] = useState("");

    const inputHandler = (e) => {
        SetValue(e.target.value)
    }

    const clickHandler = () => {
        SetEating(prev => [value, ...prev])
    }
    return (
        <div>
            <input onChange={inputHandler} type="text"/>
            <buttont onClick={clickHandler}>추가</buttont>
            <ul>
                {eating.map((item,idx) =>(
                    <li key={idx}>{item}</li>
                ))}
            </ul>
        </div>
    )
}

export default Sol1;