import React from "react";
import styled from "styled-components";
import { Text } from "react-native";


const Container = styled.View`
    flex : 1;
    background-color : ${({theme}) => theme.background};
`

const Channel = () => {
    return(
        <Container>
            <Text style={{font:24}}>ID : {route.params?.id}</Text>
            <Text style={{font:24}}>Title : {route.params?.title}</Text>
        </Container>
    )
}

export default Channel;