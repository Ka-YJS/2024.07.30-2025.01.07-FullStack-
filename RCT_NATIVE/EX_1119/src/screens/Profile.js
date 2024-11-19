import React,{useContext, useState} from "react";
import styled,{ ThemeContext } from "styled-components";
import { Text } from "react-native";
import { Button,Image,Input } from  '../components/Index'
import { UserContext,ProgressContext } from '../contexts/Index'
import {logout, getCurrentUser, updateUserInfo} from '../utils/firebase'
import { Alert } from "react-native";

const Container = styled.View`
    flex : 1;
    background-color : ${({theme}) => theme.background};
    justify-content : center;
    align-items : center;
    padding : 0 20px;
`;

const Profile = ({}) => {

    const {dispatch} = useContext(UserContext);
    const {spinner} = useContext(ProgressContext);
    const theme = useContext(ThemeContext);

    //현재로그인한 정보 가져옴
    const user = getCurrentUser();
    console.log(user);
    //유저의 프로필사진url을 가져와서 state에 저장
    const [photoURL, setPhotoUrl] = useState(user.photoUrl);

    //로그아웃버튼을 눌렀을 때 실행되는 함수
    const _handleLogoutButtonPress = async () => {
        try {
            spinner.start();
            await logout(); 
        } catch {
            console.log('[Profile] logout : ', error.message);
        }finally{
            dispatch({});
            spinner.stop();
        }
    }

    //수정된 이미지 업로드
    const _handlePhotoChange = async url => {
        try {
            spinner.start();
            const photoUrl = await updateUserInfo(url);
            setPhotoUrl(photoUrl);
        } catch (error) {
            Alert.alert("Photo Error",error.message);
        }finally{
            spinner.stop();
        }
    }

    return(
        <Container>
            <Image 
                url={photoURL} onChangeImage={_handlePhotoChange}
                showButton rounded />
            <Input label="Name" value={user.displayName} disabled />
            <Input label="Email" value={user.email} disabled />
            {/* <Text style={{fontSize:24}}>Profile</Text> */}
            <Button title="logout" onPress={_handleLogoutButtonPress}
            containerStyle={{marginTop : 30, backgroundColor : theme.buttonLogout}}/>
        </Container>
    )
}

export default Profile;