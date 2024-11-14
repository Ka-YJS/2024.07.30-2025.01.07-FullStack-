import React,{ useState, useRef, useEffect, useContext } from 'react';
import styled from 'styled-components/native';
import { Image, Input, Button } from '../components/Index';
import { images } from '../utils/Images';
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view';
import { validateEmail,removeWhitespace } from '../utils/common';
import { useSafeAreaInsets } from 'react-native-safe-area-context';
import { Alert } from 'react-native';
import { login } from '../utils/firebase';
import { ProgressContext, UserContext } from '../contexts/Index';

const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
  background-color: ${({ theme }) => theme.background};
  padding: 0 20px;
  padding-top: ${({insets:{top}}) => top}px;
  padding-bottom: ${({insets:{bottom}}) => bottom}px;
`;

const ErrorText = styled.Text`
  align-items : flex-start;
  width: 100%;
  height: 20px;
  margin-bottom: 10px;
  line-height: 20px;
  color: ${({theme}) => theme.errorText};
`

const Login = ({ navigation }) => {

  const {spinner} = useContext(ProgressContext);
  const {dispatch} = useContext(UserContext);

  const[email, setEmail] = useState('');
  const[password,setPassword] = useState('');
  //password를 입력하는 input을 조종하기위한 useRef
  const passwordRef = useRef();//useRef : DOM객체(컴포넌트)를 조종
  const [errorMessage, setErrorMessage] = useState('');

  const [disabled, setDisabled] = useState(true);
  const insets = useSafeAreaInsets();
  /*useSafeAreaInsets : 화면의 안전영역을 고려해 레이아웃을 조정할 때 사용하는 Hook
  -ios장치의 상단노치나 하단 홈버튼영역과 같은 안전구역을 감안해 레이아웃을 맞추기 위해 사용
  -hook은 {top, bottom, left, right}형태의 객체를 반환함
  -안전영역의 높이나 너비를 픽셀단위로 제공*/

    useEffect(() => {//이메일입력 -> 비번입력 -> 조건에 맞게 입력했을 때 false로 바꿈
    setDisabled(!(email && password && !errorMessage));
  }, [email, password, errorMessage]);
  //email, password 입력마다 useState값 다름

  const _handleEmailChange = email => {
    const changedEmail = removeWhitespace(email);
    setEmail(changedEmail);
    setErrorMessage(
      validateEmail(changedEmail) ? '' : 'Please verify your email.'
    );
  };
  
  const _handlePasswordChange = password => {
    setPassword(removeWhitespace(password));
  };

  //Button컴포넌트에 전달할 함수 -> 지금당장은 기능 없음 -> 로그인기능
  const _handleLoginButtonPress = async () => {
      try {
        spinner.start();
        const user = await login({email,password});
        dispatch(user);
        Alert.alert('Login Success', user.email)
      } catch (error) {
        Alert.alert('Login Error', error.message);
      }finally {
        spinner.stop();
      }
  };

  return (
    /*다른 공간을 누르면 키보드가 사라지고 
    ios로 봤을때 비번입력하는 input이 키보드에 가리는걸방지*/
    <KeyboardAwareScrollView
      contentContainerStyle={{flex:1}}
      extraScrollHeight={20}>
      {/* <TouchableWithoutFeedback onPress={Keyboard.dismiss}> */}
        <Container insets={insets}>
          {/* url과style을 props로전달 */}
          {/* <Text style={{fontSize: 30}}>Login Screen</Text> */}
          {/* <Button title="Signup" onPress={() => navigation.navigate('Signup')}/> */}
          <Image url={images.logo} style={{borderRadius : 8}}/>
          {/* 이메일을입력하는input */}
          <Input
          label="Email"
          value={email}
          // onChangeText={text => setEmail(text)}
          onChangeText={_handleEmailChange}
          onSubmitEditing={() => passwordRef.current.focus()}
          placeholder="Email"
          returnKeyType="next"
        />
        <Input
          ref={passwordRef}//useRef설정
          label="Password"
          value={password}
          // onChangeText={text=>setPassword(text)}
          onChangeText={_handlePasswordChange}
          onSubmitEditing={_handleLoginButtonPress}
          // onSubmitEditing={() => {}}
          placeholder="Password"
          returnKeyType="done"
          isPassword={true}
        />
        <ErrorText>{errorMessage}</ErrorText>
        {/* 로그인버튼 */}
        <Button title="Login" onPress={_handleLoginButtonPress}
          disabled={disabled} />
          {/* 여기서의 disabled는 활성화여부를 확인 */}
        {/* 회원가입버튼 */}
        <Button 
          title="Sign up with email"
          onPress={() => navigation.navigate('Signup')}
          isFilled={false}
        />
        </Container>
        {/* </TouchableWithoutFeedback> */}
    </KeyboardAwareScrollView>
  );
};
  
export default Login;