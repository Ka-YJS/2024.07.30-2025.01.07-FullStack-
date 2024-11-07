import React, { useLayoutEffect } from 'react';
import styled from 'styled-components/native';
import { MaterialCommunityIcons } from '@expo/vector-icons';

const Container = styled.View`
  flex: 1;
  justify-content: center;
  align-items: center;
`;
const StyledText = styled.Text`
  font-size: 30px;
  margin-bottom: 10px;
`;

const Item = ({navigation, route}) => {
    /*useLayoutEffect()
    -useLayoutEffect은 useEffect와 사용법 동일, 같은방식으로 동작
    -차이점 : 컴포넌트가 업데이트된 직후 화면이 렌더링되기전에 실행됨
        -> 이 특징때문에 화면을 렌더링하기 전에 변경할 부분이 있거나 수치등을
        측정해야하는 경우 많이 사용됨*/
    useLayoutEffect(() => {
        navigation.setOptions({
            headerBackTitleVisible : false,
            headerBackTintColor : '#ffffff',
            headerLeft : ({onPress, tintColor}) => {
              return(
                <MaterialCommunityIcons
                name="keyboard-backspace"
                size={30}
                style={{marginLeft:11}}
                color={tintColor}
                onPress={onPress}/>
              )
          },//headerLeft
          headerRight : ({tintColor}) => (
            <MaterialCommunityIcons
              name="home-variant"
              size={30}
              style={{marginRight:11}}
              color={tintColor}
              onPress={() => navigation.popToTop()} />
          )//headerRight
        })//setOptions
    },[])//useLayoutEffect

  return (
    <Container>
      <StyledText>Item</StyledText>
      <StyledText>ID : {route.params.id}</StyledText>
      <StyledText>Name : {route.params.name}</StyledText>
    </Container>
  );
};

export default Item;