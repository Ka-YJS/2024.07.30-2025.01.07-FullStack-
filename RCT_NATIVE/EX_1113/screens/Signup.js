import React,{useState, useEffect, useRef} from 'react';
import styled from 'styled-components';
import { Text } from 'react-native';
import { Image, Input, Button} from '../components/Index';
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view';
import { validateEmail, removeWhitespace } from '../utils/common';
import { theme } from '../Theme';
import { images } from '../utils/Images';

const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
  background-color: ${({ theme }) => theme.background};
  padding : 40px 20px;
`;

const ErrorText = styled.Text`
  align-items: center;
  width: 100%;
  height: 20px;
  margin-bottom: 10px;
  line-height: 20px;
  color: ${({theme}) => theme.errorText}
`;

const Signup = () => {

  const [name, setName] = useState('');//이름관리state
  const [email, setEmail] = useState('');//아이디(이메일)관리state
  const [password, setPassword] = useState('');//비번관리state
  const [passwordConfirm, setPasswordConfirm] = useState('');//비번일치여부관리state
  const [errorMessage, setErrorMessage] = useState('');//에러메세지관리state
  const [disabled, setDisabled] = useState(true);//버튼활성화여부state
  const [photoUrl, setPhotoUrl] = useState(images.photo);

  const emailRef = useRef();
  const passwordRef = useRef();
  const passwordConfirmRef = useRef();
  const didMountRef = useRef();

  useEffect(() => {
    if(didMountRef.current)
    {let _errorMessage = '';
      if(!name){
        _errorMessage = 'Please enter your name.';
      }else if(!validateEmail(email)){
        _errorMessage = 'Please verify your email.';
      }else if(password.length<6){
        _errorMessage = 'The password must contain 6 characters at least.';
      }else if(password!==passwordConfirm){
        _errorMessage = 'Password need to match.';
      }else{
        _errorMessage='';
      }
    setErrorMessage(_errorMessage);
  }else{
    didMountRef.current = true;
  }}, [name, email, password, passwordConfirm]);

  useEffect(() => {
    setDisabled(
      !(name && email && password && passwordConfirm && !errorMessage)
    )
  }, [name, email, password, passwordConfirm, errorMessage])

  const _handleSignupButtonPress = () => {};

  return (
    <KeyboardAwareScrollView extraScrollHeight={20}>
      {/* contentContainerStyle = {{flex:1}}
      extraHeight={20} */}
      <Container>
        <Image rounded url={photoUrl} showButton
          onChangeImage={url => setPhotoUrl(url)} />
        {/* 이름 */}
        <Input 
          label = "Name"
          value = {name}
          onChangeText = {text => setName(text)}
          //onChangeText : 텍스트가 변할 때마다 state에 반영
          onSubmitEditing = {() => {//완료버튼 누를 시 state에 반영, 이메일칸으로 포커스 이동
            setName(name.trim());
            emailRef.current.focus();
          }}
          onBlur={() => setName(name.trim())}//포커스빠져도 이름을 state에 반영
          placeholder = "Name"
          returnKeyType = "next"/>
        {/* <Text style={{fontSize : 30}}>Signup Screen</Text> */}
        {/* 이메일 */}
        <Input 
          ref={emailRef}
          label = "Email"
          value = {email}
          onChangeText = {text => setEmail(removeWhitespace(text))}
          onSubmitEditing = {() => passwordRef.current.focus()}
          placeholder = "Email"
          returnKeyType = "next"/>
        {/* 비밀번호 */}
        <Input 
          ref={passwordRef}
          label = "Password"
          value = {password}
          onChangeText = {text => setPassword(removeWhitespace(text))}
          onSubmitEditing = {() => passwordConfirmRef.current.focus()}
          placeholder = "Password"
          returnKeyType = "done"
          isPassword/>
          {/* 비밀번호확인 */}
        <Input 
          ref={passwordConfirmRef}
          label = "Password Confirm"
          value = {passwordConfirm}
          onChangeText = {text => setPasswordConfirm(removeWhitespace(text))}
          onSubmitEditing = {_handleSignupButtonPress}
          placeholder = "Password"
          returnKeyType = "done"
          isPassword/>
          <ErrorText>{errorMessage}</ErrorText>
          <Button
            title="Signup"
            onPress={_handleSignupButtonPress}
            disabled={disabled}/>
      </Container>
    </KeyboardAwareScrollView>
    
  );
};

export default Signup;