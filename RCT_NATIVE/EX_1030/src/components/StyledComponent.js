import React, {useState} from "react";
import styled from "styled-components";
import { View, Text, Pressable } from "react-native";

/*사용법 : const 변수명 = styled.컴포넌트명`CSS` 
        -> 변수명을 컴포넌트로 쓸 수 있음
        -> 새로운 컴포넌트를 생성한 것이라고 보면 됨*/

    const Container = styled.View`
        flex: 1;
        justify-content: center;
        align-items: center;
        background-color: #fff;
    `
    const Title = styled.Text`
        font-size: 24px;
        font-weight: bold;
        color: #333;
        margin-bottom: 20px;
    `
    
    const StyledButton = styled.Pressable`
        padding: 10px 20px;
        background-color: #007AFF;
        border-radius: 8px;
        margin-top: 10px;
    `
    const ButtonText = styled.Text`
        color: white,
        font-size: 16px;
    `
    export const Styled = () => {
        const[count,setCount] = useState(0);
        return( 
            <Container>
                <Title>Styled components Example</Title>
                <StyledButton onPress={() => setCount(prev => setCount(prev+1))}>
                    <ButtonText>Click count: {count}</ButtonText>
                </StyledButton>
            </Container>
        );
    }