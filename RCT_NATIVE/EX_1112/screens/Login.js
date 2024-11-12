import React,{ useState, useRef } from 'react';
import styled from 'styled-components/native';
import { Image, Input } from '../components/Index';
import { images } from '../utils/Images';
import { KeyboardAwareScrollView } from 'react-native-keyboard-aware-scroll-view';

const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
  background-color: ${({ theme }) => theme.background};
  padding:20px;
`;

const Login = ({ navigation }) => {

  const[email, setEmail] = useState('');
  const[password,setPassword] = useState('');
  const passwordRef = useRef();

  return (

    <KeyboardAwareScrollView
      contentContainerStyle={{flex:1}}
      extraScrollHeight={20}>
      {/* <TouchableWithoutFeedback onPress={Keyboard.dismiss}> */}
        <Container>
          {/* <Text style={{fontSize: 30}}>Login Screen</Text> */}
          {/* <Button title="Signup" onPress={() => navigation.navigate('Signup')}/> */}
          <Image url={images.logo} style={{borderRadius : 8}}/>
          <Input
          label="Email"
          value={email}
          onChangeText={text => setEmail(text)}
          onSubmitEditing={() => passwordRef.current.focus()}
          placeholder="Email"
          returnKeyType="next"
        />
        <Input
          ref={passwordRef}
          label="Password"
          value={password}
          onChangeText={text=>setPassword(text)}
          onSubmitEditing={() => {}}
          placeholder="Password"
          returnKeyType="done"
          isPassword
        />
        </Container>
        {/* </TouchableWithoutFeedback> */}
    </KeyboardAwareScrollView>
  );
};
  
export default Login;