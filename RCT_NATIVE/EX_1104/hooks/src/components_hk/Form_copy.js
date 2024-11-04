import React,{useState,useEffect} from "react";
import styled from "styled-components";

const StyledTextInput = styled.TextInput.attrs({
    autoCapitalize : 'none',
    autoCorrect : false
})
`
    border : 1px solid #757575;
    padding : 10px;
    margin : 10px 0;
    width : 200px;
    font-size : 20px;
`

const StyledText = styled.Text`
    font-size : 24px;
    margin : 10px;
`

const Form = () => {

    const [name, setName] = useState('');
    const [email, setEmail] = useState('');

    useEffect(() => {
        console.log(`\n====Form Component Mount====\n`)
        return() => 
            // console.log(`name : ${name} , email : ${email}\n`)
            console.log(`\n====Form Component UnMount====\n`)
        /*  -위에가 clean up함수임
            -useEffect의 실행조건이 빈배열인 경우 컴포넌트가 언마운트될 때
            정리함수를 실행함*/
    },[email])
    //두번째 배열에는 어떤 상황에서만 useEffect를 사용하고싶은지 정할 수 있음
    return(
        <>
        <StyledText>Name : {name}</StyledText>
        <StyledText>Email : {email}</StyledText>

        <StyledTextInput 
            value = {name}
            onChangeText = {text => setName(text)}
            placeholder = "name"
        />
        <StyledTextInput 
            value = {email}
            onChangeText = {text => setEmail(text)}
            placeholder = "email"
        />

        </>
    );

}

export default Form;

