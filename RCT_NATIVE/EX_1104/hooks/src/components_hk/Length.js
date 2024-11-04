import React,{useMemo, useState} from "react";
import styled from "styled-components";
import Button from "./Button";

//문자열의 길이를 계산하는 컴포넌트 만들기

const StyledText = styled.Text`
    font-size : 24px;
`

const getLength = text => {
    console.log(`Target Text : ${text}`)
    return text.length;
}

const list = ['JavaScript','Expo','Expo','React Native']

let idx = 0;

const Length = () => {
    const [text, setText] = useState(list[0]);
    const [length, setLength] = useState('');

    const _onPress = () => {
        setLength(getLength(text));
        ++idx;
        if(idx<list.length) setText(list[idx]);
    }

    return(
        <>
            <StyledText>Text : {text}</StyledText>
            <StyledText>Length : {length}</StyledText>
            <Button title = "Get Length" onPress={_onPress} />
        </>
    )
}

export default Length;