import React from "react";
import styled from "styled-components";
import { Text, Button } from "react-native";
import { theme } from "../Theme";


const Container = styled.View`
    flex : 1;
    background-color : ${({theme}) => theme.background};
`

const ChannelCreation = ({navigation}) => {
    return(

        <Container>
            <Text style={{font:24}}>Channel Creation</Text>
            <Button title="Channel" onPress={() => navigation.navigate('Channel')}/>
        </Container>
    )
}

export default ChannelCreation;