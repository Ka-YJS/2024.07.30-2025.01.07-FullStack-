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
            <Text style={{font:24}}>Channel</Text>
        </Container>
    )
}

export default Channel;