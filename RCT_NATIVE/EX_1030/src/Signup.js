import React, { useState } from "react";
import styled from "styled-components";
import {View, Text, TextInput} from 'react-native'

const SignUp = () => {

    const [text, setText] = useState('');
    const _onChange = event => setText(event.nativeEvent.text);

    return(
        <View>
            <Text style={{margin:10, fontSize: 30}}>이름 : {text}</Text>
            <Text style={{margin:10, fontSize: 30}}>이메일 : {text}</Text>
            <Text style={{margin:10, fontSize: 30}}>비밀번호 : {text}</Text>
            <Text style={{margin:10, fontSize: 30}}>비밀번호 확인 : {text}</Text>

            <TextInput
                style={{}} />
        </View>
    )
}

export default SignUp;