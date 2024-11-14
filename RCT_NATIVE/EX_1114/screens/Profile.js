import React,{useContext} from "react";
import styled from "styled-components";
import { Text } from "react-native";
import { Button } from  '../components/Index'
import { UserContext} from '../contexts/Index'
import {logout} from '../utils/firebase'

const Container = styled.View`
    flex : 1;
    background-color : ${({theme}) => theme.background}
`;



const Profile = ({}) => {

    const {dispatch} = useContext(UserContext);

    const _handleLogoutButtonPress = async () => {
        try {
            await logout(); 
        } catch {
            console.log('[Profile] logout : ', error.message);
        }finally{
            dispatch({});
        }
    }

    return(
        <Container>
            {/* <Text style={{fontSize:24}}>Profile</Text> */}
            <Button title="logout" onPress={_handleLogoutButtonPress}/>
        </Container>
    )
}

export default Profile;